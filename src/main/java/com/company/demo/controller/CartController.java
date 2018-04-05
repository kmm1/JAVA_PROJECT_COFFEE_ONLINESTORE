package com.company.demo.controller;

import com.company.demo.dto.UserDto;
import com.company.demo.entity.Coffee;
import com.company.demo.entity.Order;
import com.company.demo.entity.User;
import com.company.demo.service.CoffeeService;
import com.company.demo.service.ConfigurationService;
import com.company.demo.service.OrderService;
import com.company.demo.service.UserService;
import com.company.demo.validation.CheckOutValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Kate M on 02.04.2018.
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    private UserService userService;
    private OrderService orderService;
    private CoffeeService coffeeService;
    private ConfigurationService configurationService;
    private UserDto userDto;

    @Autowired
    public CartController(UserService userService, OrderService orderService, CoffeeService coffeeService, ConfigurationService configurationService, UserDto userDto) {
        this.userService = userService;
        this.orderService = orderService;
        this.coffeeService = coffeeService;
        this.configurationService = configurationService;
        this.userDto = userDto;
    }

    @ModelAttribute("infoAboutProductsInCart")
    public Map<Coffee, Integer> showProductsInCart() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User foundUser = userService.findUserByName(name);
        Map<Coffee, Integer> infoAboutProductsInCart = orderService.findInfoAboutProductsInCartByUserId(foundUser.getId());

        return infoAboutProductsInCart;
    }

    @ModelAttribute("cartTotal")
    public Double showCartTotal() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User foundUser = userService.findUserByName(name);
        Double cartTotal = orderService.findCartTotalByUserId(foundUser.getId());
        return cartTotal;
    }

    @ModelAttribute("order")
    public Order order() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User foundUser = userService.findUserByName(userName);
        return orderService.findUserCartByUserId(foundUser.getId());
    }

    @GetMapping(path = "/show")
    public String showCart(Model model) {
        model.addAttribute("userClickShowCart", true);
        return "index";
    }

    @GetMapping(path = "add/product/{productId}")
    public String addProductToCart(@PathVariable("productId") Long productId, Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        orderService.addProductsToUserCartByUserNameProductId(name, productId);
        return "redirect:/cart/show";
    }

    @GetMapping(path = "/{productId}/update")
    public String updateProductInCart(@PathVariable("productId") Long productId,
                                      @RequestParam("amount") int amountToUpdate, Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        if (amountToUpdate > 0) {
            orderService.updateProductsInUserCartByUserIdProductIdAmount(name, productId, amountToUpdate);
        }
        return "redirect:/cart/show";
    }


    @GetMapping(path = "/{productId}/delete")
    public String deleteProductInCart(@PathVariable("productId") Long productId, Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        orderService.deleteProductsInUserCartByUserNameAndProductId(name, productId);
        return "redirect:/cart/show";
    }

    @GetMapping(path = "/checkout")
    public String checkoutPage(Model model, HttpSession session) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User foundUser = userService.findUserByName(userName);
        double cartTotal = orderService.findCartTotalByUserId(foundUser.getId());
        double discount = configurationService.getDiscount(userName);
        double shippingRate = configurationService.getShippingRate(userName, userDto.getCartTotal());
        double total = cartTotal - discount + shippingRate;
        session.setAttribute("total", total);
        session.setAttribute("shippingRate", shippingRate);
        session.setAttribute("foundUser", foundUser);
        model.addAttribute("discount", discount);
        model.addAttribute("total", total);
        model.addAttribute("userClickCheckOut", true);
        return "index";
    }

    @PostMapping(path = "/confirm")
    public String checkoutPage(@Valid Order order, BindingResult bindingResult, @RequestParam("address") String address,
                               @RequestParam("receiverName") String receiverName,
                               Model model, HttpSession session) {
        new CheckOutValidation(orderService).validate(order, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:checkout";
        }
        double total = (double) session.getAttribute("total");
        double shippingRate = (double) session.getAttribute("shippingRate");
        User foundUser = (User) session.getAttribute("foundUser");
        orderService.updateOrder(address, receiverName, shippingRate, total, foundUser.getId());
        model.addAttribute("confirmOrder", true);
        return "index";
    }


}
