package com.jupiterspring.springblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String hello(){
        return "home";  //==== why have this return ? does it map to the specific template name ( ? )
    }
}