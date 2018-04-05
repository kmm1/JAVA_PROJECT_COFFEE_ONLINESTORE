package com.company.demo.controller;//package com.company.controller;

import com.company.demo.dto.UserDto;
import com.company.demo.entity.Coffee;
import com.company.demo.entity.Order;
import com.company.demo.entity.User;
import com.company.demo.service.OrderService;
import com.company.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by Kate M on 26.03.2018.
 */
@ControllerAdvice
@SessionAttributes(types = {UserDto.class})
public class GlobalController {


    private UserService userService;
    private OrderService orderService;

    @Autowired
    public GlobalController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    private UserDto userDto;


    @ModelAttribute("userDto")
    public UserDto getUserModel() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User foundUser = userService.findUserByName(authentication.getName());
        if (foundUser != null) {
            Long numberOfProductsInOrder = orderService.countProductsInCartByUserId(foundUser.getId());
            Order currentOrder = orderService.findUserCartByUserId(foundUser.getId());
            List<Coffee> products = currentOrder.getCoffeesInOrder();
            double sum = products.stream().mapToDouble(c -> c.getPrice().doubleValue()).sum();
            userDto = new UserDto(foundUser.getId(), foundUser.getName(),
                    foundUser.getRole(), numberOfProductsInOrder, currentOrder, sum);
        }
        return userDto;
    }
}
