package it.controllertest.springbootcontroller.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

import it.controllertest.springbootcontroller.model.Author;
import it.controllertest.springbootcontroller.repository.AuthorRepository;
import it.controllertest.springbootcontroller.service.AuthorService;

@Controller
@RequestMapping(value = "authors")
public class AuthorController {

    //@Autowired
    //private AuthorRepository authorRepository;    -> non lo useremo più nel controller

    @Autowired
    private AuthorService authorService;

    // sul path localhost:8080/authors posso richiamare la funzione test
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public @ResponseBody String test() {        // specifichiamo @ResponseBody per dire il tipo di ritorno della funzione
        return "test get";
    }

    @RequestMapping(value = "testpost", method = RequestMethod.POST)
    public @ResponseBody String testPost(@RequestBody String test) {        // specifichiamo @RequestBody per dire il tipo che diamo in input
        return "test post " + test;
    }

    @GetMapping
    public @ResponseBody List<Author> getAll(@RequestParam(name = "firstname", required = false) String firstname,@RequestParam(name = "lastname", required = false) String lastname){
       return authorService.read(firstname, lastname);
    }

    // rotta -> "/authors" POST
    @PostMapping
    public @ResponseBody Author insertAuthor(@RequestBody Author a){
        return authorService.create(a);
    }

    // rotta parametrica -> "/authors/:id" DELETE
    // @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @DeleteMapping("{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id) throws Exception {        // specifichiamo @RequestBody per dire il tipo che diamo in input
        return authorService.delete(id);
    }

    // rotta parametrica -> "/authors/:id" PUT
    // @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @PutMapping("{id}")
    public @ResponseBody Author put(@PathVariable("id") Integer id, @RequestBody Author a) throws Exception {        // specifichiamo @RequestBody per dire il tipo che diamo in input
        return authorService.update(id, a);
    }


}
