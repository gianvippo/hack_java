package it.controllertest.springbootcontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.controllertest.springbootcontroller.dto.CreatePostDTO;
import it.controllertest.springbootcontroller.service.AuthorService;
import it.controllertest.springbootcontroller.service.PostService;

@Controller
@RequestMapping(value = "posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private AuthorService authorService;
    
    @GetMapping
    public String postsView(Model model) {
        model.addAttribute("title", "Posts");
        model.addAttribute("posts", postService.read());
        return "posts/index";
    }

    @GetMapping("add")
    public String postsAddView(Model model) {
        model.addAttribute("title", "Add Post");
        model.addAttribute("post", new CreatePostDTO());
        model.addAttribute("authors", authorService.readAll());
        return "posts/add";
    }

    @PostMapping("save")
    public String postsSave(@ModelAttribute("post") CreatePostDTO createPostDTO) throws Exception {
        postService.create(createPostDTO);
        return "redirect:/posts";
    }

}
