package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String postIndexPage(){
        return "Posts Index Page";
    }

    @RequestMapping(path="/posts/{id}", method= RequestMethod.GET)
    @ResponseBody
    public String postId(@PathVariable int id){
        return "Post number" + id;
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
