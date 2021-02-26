package com.jupiterspring.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonalController {

    @GetMapping("/weather")
    public String weather(){
        return "personal/weatherMap";
    }

    @GetMapping("/")
    public String aboutMe(Model model){
        model.addAttribute("title", "Personal Site");
        return "personal/about";
    }

}
