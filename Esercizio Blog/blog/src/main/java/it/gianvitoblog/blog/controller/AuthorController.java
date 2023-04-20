package it.gianvitoblog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.gianvitoblog.blog.model.Author;
import it.gianvitoblog.blog.service.AuthorService;

@Controller
@RequestMapping(value = "authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    
    @GetMapping
    public String authorsView(Model model) {
        model.addAttribute("title", "Authors");
        model.addAttribute("authors", authorService.readAll());
        return "authors/index";
    }

    @GetMapping("client")
    public String authorsViewClient(Model model) {
        model.addAttribute("title", "Authors Client Rendering");
        return "authors/index-client-rendering";
    }

    @GetMapping("add")
    public String authorsViewAdd(Model model) {
        model.addAttribute("title", "Add Author");
        model.addAttribute("author", new Author());
        return "authors/add";
    }

    @PostMapping("save")
    public String authorsSave(@ModelAttribute("author") Author author) throws Exception {
        authorService.create(author);
        return "redirect:/authors";
    }

    @GetMapping("modify/{id}")
    public String authorsViewModify(@PathVariable("id") Integer id, Model model) throws Exception{
        model.addAttribute("title", "Update Author");
        model.addAttribute("object", authorService.readOne(id));
        return "authors/modify";
    }

    @PostMapping("update")
    public String authorsViewUpdate(@ModelAttribute("object") Author author) throws Exception{
        authorService.update(author.getId(), author);
        return "redirect:/authors";
    }
}
