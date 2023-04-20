package it.gianvitoblog.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("title", "Homepage");
        model.addAttribute("authorsPath", "authors");
        model.addAttribute("postsPath", "posts");
        model.addAttribute("commentsPath", "comments");
        return "index";
    }
}
