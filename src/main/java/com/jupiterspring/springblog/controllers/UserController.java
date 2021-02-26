package com.jupiterspring.springblog.controllers;

import com.jupiterspring.springblog.model.User;
import com.jupiterspring.springblog.repositories.UserRepository;
import com.jupiterspring.springblog.services.UserDetailsLoader;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userDao;
    private final UserDetailsLoader userDetailsLoader;

    public UserController(PasswordEncoder passwordEncoder, UserRepository userDao, UserDetailsLoader userDetailsLoader){
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
        this.userDetailsLoader = userDetailsLoader;
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("title", "Log In Page");
        return "users/login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/homePage";
    }


    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("title", "Register Page");
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String registered(Model model, @ModelAttribute User user, @RequestParam String passwordMatch){
        String enteredPassword = user.getPassword();
        if(!passwordMatch.equals(enteredPassword)){
            model.addAttribute("incorrectPassword", true);
            return "users/register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
        model.addAttribute("title", user.getUsername());
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String profilePage(Model model){
        return "users/profile";
    }

}
