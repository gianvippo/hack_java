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
import org.springframework.web.bind.annotation.ResponseBody;

import it.controllertest.springbootcontroller.model.Author;
import it.controllertest.springbootcontroller.repository.AuthorRepository;

@Controller
@RequestMapping(value = "authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    // sul path localhost:8080/authors posso richiamare la funzione test
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public @ResponseBody String test() {        // specifichiamo @ResponseBody per dire il tipo di ritorno della funzione
        return "test get";
    }

    @RequestMapping(value = "testpost", method = RequestMethod.POST)
    public @ResponseBody String testPost(@RequestBody String test) {        // specifichiamo @RequestBody per dire il tipo che diamo in input
        return "test post " + test;
    }

    // rotta -> "/authors" GET
    @GetMapping
    public @ResponseBody List<Author> getAll(){
        return authorRepository.findAll();
    }

    // rotta -> "/authors" POST
    @PostMapping
    public @ResponseBody Author insertAuthor(@RequestBody Author a){
        return authorRepository.save(a);
    }

    // rotta parametrica -> "/authors/:id" DELETE
    // @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @DeleteMapping("{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id) {        // specifichiamo @RequestBody per dire il tipo che diamo in input
        authorRepository.deleteById(id);
        return "OK";
    }

    // rotta parametrica -> "/authors/:id" PUT
    // @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @PutMapping("{id}")
    public @ResponseBody Author put(@PathVariable("id") Integer id, @RequestBody Author a) throws Exception {        // specifichiamo @RequestBody per dire il tipo che diamo in input
        Optional<Author> dbOptionalAuthor = authorRepository.findById(id);
        if (dbOptionalAuthor.isPresent()) {
            Author dbAuthor = dbOptionalAuthor.get();
            dbAuthor.setFirstname(a.getFirstname());
            dbAuthor.setLastname(a.getLastname());
            dbAuthor.setEmail(a.getEmail());
            authorRepository.save(dbAuthor);
            return dbAuthor;
        }

        throw new Exception();
    }


}
