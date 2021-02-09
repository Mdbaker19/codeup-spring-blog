package com.jupiterspring.springblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @GetMapping("/{method}/{x}/and/{y}")
    @ResponseBody
    public int eval(@PathVariable String method, @PathVariable int x, @PathVariable int y){
        return calcForMe(method, x, y);
    }

    @PostMapping("/calc")
    public String formCalc(@RequestParam(name = "op") String op, @RequestParam(name = "n1") int n1, @RequestParam(name = "n2") int n2, Model model){
        int answer = calcForMe(op, n1, n2);
        model.addAttribute("answer", answer);
        return "answer";
    }





    private static int calcForMe(String method, int x, int y){
        switch (method) {
            case "add":
                return x + y;
            case "subtract":
                return x - y;
            case "multiply":
                return x * y;
            case "divide":
                return x / y;
            default:
                return 0;
        }
    }

}
