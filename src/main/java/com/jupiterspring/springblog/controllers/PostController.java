package com.jupiterspring.springblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @RequestMapping(path = "/post", method = RequestMethod.GET)
    @ResponseBody
    public String plainPost(){
        return "post index page";
    }

    @RequestMapping(path = "/post/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String plainPost(@PathVariable int id){
        return "view an individual post for id " + id;
    }

    @RequestMapping(path = "/post/create", method = RequestMethod.GET)
    @ResponseBody
    public String createForm(){
        return "view form for creating a post";
    }

    @RequestMapping(path = "/post/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(){
        return "Create a new post";
    }

}
