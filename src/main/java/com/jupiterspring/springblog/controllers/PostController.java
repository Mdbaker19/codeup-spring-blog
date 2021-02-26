package com.jupiterspring.springblog.controllers;
import com.jupiterspring.springblog.model.Post;
import com.jupiterspring.springblog.model.User;
import com.jupiterspring.springblog.repositories.PostRepository;
import com.jupiterspring.springblog.repositories.UserRepository;
import com.jupiterspring.springblog.services.EmailService;
import com.jupiterspring.springblog.services.UserService;
import com.jupiterspring.springblog.util.Methods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserService userService;
    private final EmailService emailService;
    Methods m = new Methods();

    public PostController(PostRepository postDao, UserService userService, EmailService emailService){
        this.postDao = postDao;
        this.userService = userService;
        this.emailService = emailService;
    }


    @GetMapping("/post/{id}")
    public String getOne(@PathVariable long id, Model model){
        Post post = postDao.getOne(id);
        User temp = userService.getOne(1L);
        post.setUser(temp);
        model.addAttribute("post", post);
        model.addAttribute("title", post.getTitle());
        return "posts/show";
    }

    @GetMapping("/post/create")
    public String createForm(Model model){
        model.addAttribute("title", "Create Your Post");
        model.addAttribute("post", new Post());
        return "posts/createPost";
    }

    // duplicate title entry causes error page unique constraint
    @PostMapping("/post/create")
    public String createPost(@ModelAttribute Post post, Model model){
        User temp = userService.loggedInUser();
        post.setDate(new Date());
        post.setUser(temp);
        post.setAuthor(temp.getUsername()); // i believe i only need this for now while my posts are from made up users
        Post savedPost = postDao.save(post); // to use to then send an email or something
        String subject = "Post Created";
        String body = "Thank you for creating your post " + temp.getUsername() + " your ad id is " + savedPost.getId();
        emailService.prepareAndSend(savedPost, subject, body);
        model.addAttribute("post", post);
        model.addAttribute("title", post.getTitle());
        return "redirect:/postPage";
    }

    @GetMapping("/post/search")
    public String searchPost(@RequestParam Optional<String> searchValue, Model model, @PageableDefault(value = 5, sort = "title", direction = Sort.Direction.ASC) Pageable pageable){
        // the search results do not display in sets of 5 right now
        List<Post> post = postDao.findAllByTitle(searchValue.orElse("" + searchValue));
        if(post.size() < 1){
            model.addAttribute("title", searchValue);
            return "notFound";
        }
        Page<Post> postToPage = postDao.findByTitle(searchValue.orElse(""), pageable);
        model.addAttribute("page", postToPage);
        model.addAttribute("title", post.get(0).getTitle());
        return "posts/pages";
    }

    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/postPage";
    }

    @PostMapping("/post/edit")
    public String editThePost(Model model, @ModelAttribute Post post){
        User temp = userService.loggedInUser();
//        User temp = userDao.getOne(1L);
        post.setUser(temp);
        post.setAuthor(temp.getUsername());
        post.setDate(new Date());
        postDao.save(post);
        return getOne(post.getId(), model);
    }

    @GetMapping("/postPage")
    public String findIt(Model model, @PageableDefault(value = 5, sort = "title", direction = Sort.Direction.ASC) Pageable pageable){
        model.addAttribute("page", postDao.findAll(pageable));
        model.addAttribute("title", "Viewing Post Page " + (Integer.parseInt(String.valueOf(pageable.getPageNumber())) + 1));
        return "posts/pages";
    }

    @GetMapping("/post.json")
    public @ResponseBody List<Post> viewAllPostsInJSONFormat(){
        return postDao.findAll();
    }
    @GetMapping("/posts/ajax")
    public String viewAllPostsWithAjax(Model model){
        model.addAttribute("title", "Ajax Posts");
        return "posts/ajax";
    }



}
