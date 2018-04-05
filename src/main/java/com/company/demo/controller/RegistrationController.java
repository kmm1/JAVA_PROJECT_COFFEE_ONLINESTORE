package com.company.demo.controller;

import com.company.demo.entity.Order;
import com.company.demo.entity.User;
import com.company.demo.service.OrderService;
import com.company.demo.service.UserService;
import com.company.demo.validation.RegistrationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by Kate M on 21.03.2018.
 */
@Controller
public class RegistrationController {
    private UserService userService;
    private OrderService orderService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserService userService, OrderService orderService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.orderService = orderService;
        this.passwordEncoder = passwordEncoder;
    }

    @ModelAttribute("user")
    public User createNewUser() {
        return new User();
    }

    @GetMapping(path = "/register")
    public String showRegistrationPageStep1(User user, Model model) {
        return "signup";
    }

    @PostMapping(path = "/register")
    public String handleUserSubmissionStep1(@Valid User user, BindingResult bindingResult,
                                            @ModelAttribute("confirmPassword") String confirmPassword,
                                            Model model) {
        new RegistrationValidation(userService).validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        user.setRole(User.Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userService.save(user);
        Order order = new Order();
        order.setStatus(Order.OrderStatus.NEW);
        order.setUser(savedUser);
        orderService.save(order);
        return "signup-success";
    }
}
