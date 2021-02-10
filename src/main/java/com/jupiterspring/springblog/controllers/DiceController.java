package com.jupiterspring.springblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.List;

@Controller
public class DiceController {
    List<Integer> rolls = new ArrayList<>();
    int count = 0;

    @GetMapping("/roll-dice")
    public String showPage(){
        return "dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String showRoll(@PathVariable int n, Model model){
        int ran = (int) Math.floor(Math.random() * 6) + 1;
        rolls.add(n);
        String result = "";
        if (ran == n) {
           result = "Correct";
           count++;
        } else {
            result = "Wrong";
        }
        model.addAttribute("allGuesses", rolls);
        model.addAttribute("count", count);
        model.addAttribute("guess", n);
        model.addAttribute("pick", ran);
        model.addAttribute("outcome", result);
        return "dice";
    }


}
