package com.jupiterspring.springblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello from Spring";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello user, my name is "+name;
    }

    @PostMapping("/hello")
    public String greetingSelf(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name", name);
        return "name";
    }
}
