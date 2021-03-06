package com.jupiterspring.springblog.controllers;

import com.jupiterspring.springblog.model.User;
import com.jupiterspring.springblog.repositories.PostRepository;
import com.jupiterspring.springblog.repositories.UserRepository;
import com.jupiterspring.springblog.services.UserDetailsLoader;
import com.jupiterspring.springblog.services.UserService;
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
    private final PostRepository postDao;
    private final UserDetailsLoader userDetailsLoader;
    private final UserService userService;

    public UserController(PasswordEncoder passwordEncoder, UserRepository userDao, UserDetailsLoader userDetailsLoader, UserService userService, PostRepository postDao){
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
        this.userDetailsLoader = userDetailsLoader;
        this.userService = userService;
        this.postDao = postDao;

    }

    @GetMapping("/login")
    public String loginPage(Model model){
//        if(userService.loggedInUser() != null){ if you try to go to / login you are redirected to your profile
//            return "redirect:/profile";
//        }
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
        User currUser = userService.loggedInUser();
        model.addAttribute("user", currUser);
        model.addAttribute("posts", postDao.findAllByUserId(currUser.getId()));
        return "users/profile";
    }

}
