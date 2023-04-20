package it.gianvitoblog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.gianvitoblog.blog.dto.CreatePostDTO;
import it.gianvitoblog.blog.service.AuthorService;
import it.gianvitoblog.blog.service.PostService;

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
        model.addAttribute("posts", postService.readAll());
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
    public String postsSaveView(@ModelAttribute("post") CreatePostDTO createPostDTO) throws Exception {
        postService.create(createPostDTO);
        return "redirect:/posts";
    }
    
}
