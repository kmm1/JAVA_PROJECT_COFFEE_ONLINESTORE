package com.company.demo.controller;

import com.company.demo.entity.Configuration;
import com.company.demo.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by Kate M on 05.04.2018.
 */
@Controller
@RequestMapping("/manage")
public class ManagerController {

    private ConfigurationService configurationService;

    @Autowired
    public ManagerController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @ModelAttribute("configuration")
    public Configuration getConfiguration() {
        return configurationService.findById(1L);

    }

    @GetMapping("/configuration")
    public String showConfigPage(Model model) {
        model.addAttribute("showManagePage", true);
        return "index";
    }

    @PostMapping("/configuration")
    public String handleConfigPage(@Valid Configuration configuration, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("showManagePage", true);
            model.addAttribute("message", "Validation failed for User Registration");
            return "index";
        }
        configurationService.update(configuration);
        model.addAttribute("showManagePage", true);
        return "index";
    }
}
