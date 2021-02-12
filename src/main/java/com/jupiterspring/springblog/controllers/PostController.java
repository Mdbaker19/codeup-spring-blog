package com.jupiterspring.springblog.controllers;
import com.jupiterspring.springblog.model.Post;
import com.jupiterspring.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/post")
    public String allPosts(Model model){
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("title", "All Posts");
        return "posts/index";
    }

    @GetMapping("/post/{id}")
    public String getOne(@PathVariable long id, Model model){
        Post myPost = postDao.getOne(id);
        model.addAttribute("myPost", myPost);
        model.addAttribute("title", "This Post");
        return "posts/show";
    }

    @GetMapping("/post/create")
    public String createForm(Model model){
        model.addAttribute("title", "Create Your Post");
        return "posts/createPost";
    }

    @PostMapping("/post/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body, @RequestParam(name = "author") String author, Model model){
        Post newPost = new Post();
        newPost.setDate(new Date());
        newPost.setAuthor(author);
        newPost.setBody(body);
        newPost.setTitle(title);
        postDao.save(newPost);
        Post myPost = postDao.getOne(newPost.getId());
        model.addAttribute("myPost", myPost);
        model.addAttribute("title", "This Post");
        return "posts/show";
    }

    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable long id){
        Post thisPost = postDao.getOne(id);
        postDao.delete(thisPost);
        return "posts/index";
    }

}
