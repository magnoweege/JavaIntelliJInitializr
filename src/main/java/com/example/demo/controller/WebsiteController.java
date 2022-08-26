package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/website")
public class WebsiteController {

    @RequestMapping(method = RequestMethod.GET)
    public String listarWebsite() {
        return "You are in!";
    }

}
