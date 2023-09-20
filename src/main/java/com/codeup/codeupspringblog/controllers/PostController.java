package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String postIndexPage(Model model){
        Post post1 = new Post("Show Post Test", "Testing the show posts");
        Post post2 = new Post("Show Post Test2", "Testing the show posts2");
        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @RequestMapping(path="/posts/{id}", method= RequestMethod.GET)
    public String postId(@PathVariable int id, Model model){
        Post showPost = new Post("Show Post Test", "Testing the show posts");
        model.addAttribute("title", showPost.getTitle());
        model.addAttribute("body", showPost.getBody());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreatePage(){
        return "view form for creating post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreatedPost(){
        return "create a new post";
    }
}
