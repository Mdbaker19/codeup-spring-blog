package com.jupiterspring.springblog.controllers;
import com.jupiterspring.springblog.model.Post;
import com.jupiterspring.springblog.repositories.PostRepository;
import com.jupiterspring.springblog.util.Methods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    Methods m = new Methods();

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("")
    public String topPosts(Model model){
        List<Post> all = postDao.findAll();
        List<Post> top = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            top.add(all.get(i));
        }
        model.addAttribute("posts", top);
        model.addAttribute("title", "Home Page");
        return "home";
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
        newPost.setAuthor(m.cap(author));
        newPost.setBody(body);
        newPost.setTitle(title);
        postDao.save(newPost);
        Post myPost = postDao.getOne(newPost.getId());
        model.addAttribute("myPost", myPost);
        model.addAttribute("title", "This Post");
        return "posts/show";
    }

    @GetMapping("/post/search/{searchValue}")
    public String searchPost(@PathVariable String searchValue, Model model){
        System.out.println(searchValue);
        Post post = postDao.findPostByTitle(searchValue);
        model.addAttribute("myPost", post);
        model.addAttribute("title", "Viewing Searched Post");
        return "posts/show";
    }

    @GetMapping("/post/delete/{id}")
    public String deletePost(Model model, @PathVariable long id){
        Post thisPost = postDao.getOne(id);
        postDao.delete(thisPost);
        return allPosts(model);
    }

    @PostMapping("/post/edit")
    public String editThePost(Model model, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body, @RequestParam(name = "author") String author, @RequestParam(name = "currId") long id){
        Post currPost = postDao.getOne(id);
        currPost.setTitle(title);
        currPost.setBody(body);
        currPost.setAuthor(m.cap(author));
        currPost.setDate(new Date());
        postDao.save(currPost);
        return allPosts(model);
    }

}
