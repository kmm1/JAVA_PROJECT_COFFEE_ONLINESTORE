package com.rana.demo.controller;

import com.rana.demo.entity.User;
import com.rana.demo.repository.UserRepository;
import com.rana.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by Kate M on 02.04.2018.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    UserRepository userRepository;

    // inject via application.properties

    @GetMapping("/1")
    public String welcome(Map<String, Object> model) {
        model.put("message", "Hello ");
        return "index";
    }


    @GetMapping("/user")
    public String add(Model model) {
        List<User> all = userService.findAll();

        model.addAttribute("user", userService.findOne(2L));
        model.addAttribute("all", all);
        model.addAttribute("r", userRepository.findById(1L));

        System.out.println(all);
        return "index";
    }
}


