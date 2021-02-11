package com.jupiterspring.springblog.controllers;
import com.jupiterspring.springblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    Post myPost = new Post(1, "Covid is a lie", "Quit letting this run your life and get back out there. The government does not always know what is best");
    Post myPost2 = new Post(2, "Interaction", "Covid has reduced interaction with others, it is having a real impact on mental health");
    Post myPost3 = new Post(3, "President Trump", "Trump won the election");



    @GetMapping("/post")
    public String plainPost(Model model){
        List<Post> posts = new ArrayList<>();
        posts.add(myPost);
        posts.add(myPost2);
        posts.add(myPost3);
        model.addAttribute("posts", posts);
        model.addAttribute("title", "All Posts");
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
