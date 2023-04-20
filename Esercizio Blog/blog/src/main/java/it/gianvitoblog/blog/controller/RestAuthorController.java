package it.gianvitoblog.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.gianvitoblog.blog.dto.AuthorDTO;
import it.gianvitoblog.blog.model.Author;
import it.gianvitoblog.blog.service.AuthorService;

@RestController
@RequestMapping(value = "api/authors")
public class RestAuthorController {
    
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        return "test get";
    }

    @RequestMapping(value = "testpost", method = RequestMethod.POST)
    public String testPost(@RequestBody String test) {
        return "test post " + test;
    }
    
    @GetMapping
    public List<Author> getAll(
        @RequestParam(name = "firstname", required = false) String firstname
        ,@RequestParam(name = "lastname", required = false) String lastname
    )
    {
       return authorService.read(firstname, lastname);
    }

    @GetMapping("dto")
    public List<AuthorDTO> getAllDTO()
    {
       return authorService.readAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Author insertAuthor(@RequestBody Author a) throws Exception {
        return authorService.create(a);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Integer id) throws Exception {        // specifichiamo @RequestBody per dire il tipo che diamo in input
        return authorService.delete(id);
    }

    @PutMapping("{id}")
    public @ResponseBody Author put(@PathVariable("id") Integer id, @RequestBody Author a) throws Exception {        // specifichiamo @RequestBody per dire il tipo che diamo in input
        return authorService.update(id, a);
    }
}
