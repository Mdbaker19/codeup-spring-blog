package com.jupiterspring.springblog.controllers;
import com.jupiterspring.springblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    Post myPost = new Post(1, "Covid is a lie", "Quit letting this run your life and get back out there. You are an adult");
    Post myPost2 = new Post(2, "Interaction", "A Lot of what covid is doing is causing more division amongst each other, that is the plan. People just naturally hate each other now, it is a problem");


    @GetMapping("/post")
    public String plainPost(Model model){
        List<Post> posts = new ArrayList<>();
        posts.add(myPost);
        posts.add(myPost2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/post/{id}")
    public String plainPost(@PathVariable int id){

        return "";
    }

    @GetMapping("/post/create")
    public String createForm(){
        return "";
    }

    @PostMapping("/post/create")
    public String createPost(){
        return "";
    }

}
