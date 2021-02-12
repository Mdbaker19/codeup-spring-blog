package com.jupiterspring.springblog.controllers;
import com.jupiterspring.springblog.model.Post;
import com.jupiterspring.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {
    Post myPost = new Post(1, "Matt", "Covid is a lie", "Quit letting this run your life and get back out there. The government does not always know what is best", new Date(1999-12-12));
    Post myPost2 = new Post(2, "Matt", "Interaction", "Covid has reduced interaction with others, it is having a real impact on mental health", new Date(1999-12-12));
    Post myPost3 = new Post(3, "Matt", "President Trump", "Trump won the election", new Date(1999-12-12));


    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }


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
    public String plainPost(@PathVariable long id, Model model){
        Post myPost = postDao.getOne(id);
        model.addAttribute("myPost", myPost);
        return "";
    }

    @GetMapping("/post/create")
    public String createForm(){

        return "posts/createPost";
    }

    @PostMapping("/post/create")
    public String createPost(){
//        Post post = new Post();
//
//        postDao.save(post);
        return "posts/index";
    }

}
