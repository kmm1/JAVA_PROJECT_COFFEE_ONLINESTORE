package com.company.demo.controller;

import com.company.demo.entity.Coffee;
import com.company.demo.service.CoffeeService;
import com.company.demo.service.OrderService;
import com.company.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * Created by Kate M on 02.04.2018.
 */
@Controller
public class HomeController {

    private UserService userService;
    private CoffeeService coffeeService;
    private OrderService orderService;

    @Autowired
    public HomeController(UserService userService, CoffeeService coffeeService, OrderService orderService) {
        this.userService = userService;
        this.coffeeService = coffeeService;
        this.orderService = orderService;
    }

    @ModelAttribute("coffeeList")
    public List<Coffee> getCoffee() {
        return coffeeService.findAllAvailable();
    }

    @GetMapping({"/", "/index", "/home"})
    public String welcome(Model model) {
        model.addAttribute("userClickHome", true);
        return "index";
    }

    @GetMapping(path = "/about")
    public String showAboutUs(Model model) {
        model.addAttribute("title", "About Us");
        model.addAttribute("userClickAbout", true);
        return "index";
    }

    @GetMapping(path = "/contact")
    public String showContact(Model model) {
        model.addAttribute("title", "Contact");
        model.addAttribute("userClickContact", true);
        return "index";
    }

    @GetMapping(path = "/show/all/products")
    public String showAllProducts(Model model) {
        model.addAttribute("userClickAllProducts", true);
        model.addAttribute("title", "ListProduct");
        return "index";
    }


}


