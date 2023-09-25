package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;
    private UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String postIndexPage(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @RequestMapping(path="/posts/{id}", method= RequestMethod.GET)
    public String postId(@PathVariable long id, Model vModel){
        if(postDao.existsById(id)) {
            Post post = postDao.findById(id).get();
            vModel.addAttribute("post", post);
            return "posts/show";
        }
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String postCreatePage(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreatedPost(@ModelAttribute Post post){
        User user = userDao.findById(1L).get();
        post.setUser(user);
//        Post post = new Post(title, body, user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @RequestMapping(path="/posts/{id}/edit", method= RequestMethod.GET)
    public String postEdit(@PathVariable long id, Model vModel){
            Post postToEdit = postDao.findById(id).get();
            vModel.addAttribute("post", postToEdit);
            return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post){
        User user = userDao.findById(1L).get();
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts/"+post.getId();
    }
}
