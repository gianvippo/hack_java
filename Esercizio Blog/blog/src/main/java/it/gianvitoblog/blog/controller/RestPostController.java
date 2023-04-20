package it.gianvitoblog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.gianvitoblog.blog.service.PostService;

@RestController
@RequestMapping(value = "api/posts")
public class RestPostController {
    
    @Autowired
    private PostService postService;


}
