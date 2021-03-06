package com.jupiterspring.springblog.controllers;
import com.jupiterspring.springblog.model.Post;
import com.jupiterspring.springblog.model.User;
import com.jupiterspring.springblog.repositories.PostRepository;
import com.jupiterspring.springblog.repositories.UserRepository;
import com.jupiterspring.springblog.services.EmailService;
import com.jupiterspring.springblog.services.FileUploadService;
import com.jupiterspring.springblog.services.UserService;
import com.jupiterspring.springblog.util.Methods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserService userService;
    private final EmailService emailService;

    @Value("${file-upload-path}")
    private String uploadPath;

    @Autowired
    FileUploadService fileUploadService;

    public PostController(PostRepository postDao, UserService userService, EmailService emailService){
        this.postDao = postDao;
        this.userService = userService;
        this.emailService = emailService;
    }




    @GetMapping("/post/{id}")
    public String getOne(@PathVariable long id, Model model){
        User currUser = new User();
        if(userService.loggedInUser() == null){
            currUser.setId(Integer.MAX_VALUE);
        } else {
            currUser = userService.loggedInUser();
        }
        System.out.println("Setting user id to : " + currUser.getId());
        model.addAttribute("currId", currUser.getId());


        Post post = postDao.getOne(id);
        System.out.println("==============");
        System.out.println(post.getImage());
        System.out.println("==============");
        System.out.println("Post viewing user id is : " + post.getUser().getId());
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
    public String createPost(@ModelAttribute Post post, Model model, @RequestParam(name = "file") MultipartFile uploadedFile) throws IOException {
        User temp = userService.loggedInUser();
        if(post.getTitle().isEmpty()){
            System.out.println("no title");
            return "redirect:/post/create";
        } else if (post.getBody().isEmpty()) {
            System.out.println("no body");
            return "redirect:/post/create";
        }

        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);
        try {
            uploadedFile.transferTo(destinationFile);
            model.addAttribute("message", "File successfully uploaded!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }


        post.setDate(new Date());
        post.setImage("/img/" + filename);
        System.out.println(post.getImage());
        post.setUser(temp);
        post.setAuthor(temp.getUsername());


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
        post.setUser(temp);
        post.setAuthor(temp.getUsername());
        post.setDate(new Date());
        System.out.println(post.getImage());
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
