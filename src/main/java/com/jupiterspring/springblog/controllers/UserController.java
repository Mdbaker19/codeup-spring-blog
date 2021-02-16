package com.jupiterspring.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("title", "Log In Page");
        return "users/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("title", "Register Page");
        return "users/register";
    }

}
