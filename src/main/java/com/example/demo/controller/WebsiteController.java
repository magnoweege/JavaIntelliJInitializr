package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteController {

    @Value("${spring.application.name}")
    String appName;

    @GetMapping(value = "/home")
    public String getWebsite( Model model) {

       model.addAttribute("appName", appName);
        return "home";

    }
}

