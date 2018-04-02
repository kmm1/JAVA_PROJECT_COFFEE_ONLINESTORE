package com.rana.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kate M on 02.04.2018.
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/product/{id}")
    public String showCart() {
        return "cart";
    }

}
