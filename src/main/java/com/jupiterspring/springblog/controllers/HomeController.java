package com.jupiterspring.springblog.controllers;
import com.jupiterspring.springblog.model.Post;
import com.jupiterspring.springblog.repositories.PostRepository;
import com.jupiterspring.springblog.services.EmailService;
import com.jupiterspring.springblog.services.UserService;
import com.jupiterspring.springblog.util.Methods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final PostRepository postDao;

    public HomeController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/")
    public String topPosts(Model model){
        List<Post> all = postDao.findAll();
        List<Post> featurePosts = new ArrayList<>();
        List<String> featurePostImages = new ArrayList<>();
        featurePostImages.add("/img/grassPuppy.jpeg");
        featurePostImages.add("/img/snowDog.jpeg");
        featurePostImages.add("/img/puppy.jpg");
        featurePostImages.add("/img/snowHusky.jpeg");
        featurePostImages.add("/img/wildHusky.jpeg");
        featurePostImages.add("/img/wildPuppy.jpeg");
        for(int i = 0; i < 6; i++){
            featurePosts.add(all.get(i));
        }
        model.addAttribute("featurePosts", featurePosts);
        model.addAttribute("imgList", featurePostImages);
        model.addAttribute("title", "Dog Blog");
        return "home";
    }

}