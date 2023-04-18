package it.controllertest.springbootcontroller.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.controllertest.springbootcontroller.dto.AuthorDTO;
import it.controllertest.springbootcontroller.model.Author;
import it.controllertest.springbootcontroller.model.Post;
import it.controllertest.springbootcontroller.repository.AuthorRepository;
import it.controllertest.springbootcontroller.repository.PostRepository;
import it.controllertest.springbootcontroller.util.exception.AuthorBadRequest;
import it.controllertest.springbootcontroller.util.exception.AuthorNotFound;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void transaction() {
        Author a = new Author();
        a.setFirstname("null");
        a.setLastname("null");
        a.setEmail("null");

        authorRepository.save(a);

        Post p1 = new Post();
        p1.setAuthor(a);
        p1.setBody("lorem ipsum");
        p1.setTitle("lorem ipsum");
        p1.setPublishDate("20230416");

        postRepository.save(p1);

        Post p2 = new Post();
        p2.setAuthor(a);
        p2.setBody("lorem ipsum 2");
        p2.setTitle("lorem ipsum 2");

        postRepository.save(p2);

    }

    @Override
    public void noTransaction() {
        Author a = new Author();
        a.setFirstname("null");
        a.setLastname("null");
        a.setEmail("null");

        authorRepository.save(a);

        Post p1 = new Post();
        p1.setAuthor(a);
        p1.setBody("lorem ipsum");
        p1.setTitle("lorem ipsum");
        p1.setPublishDate("20230416");

        postRepository.save(p1);

        Post p2 = new Post();
        p2.setAuthor(a);
        p2.setBody("lorem ipsum 2");
        p2.setTitle("lorem ipsum 2");

        postRepository.save(p2);
    }

    @Override
    public List<Author> read(String firstname, String lastname) {
        if (firstname != null && lastname != null)
            return authorRepository.findByFirstnameAndLastname(firstname, lastname);
        else if (firstname != null)
            return authorRepository.findByFirstname(firstname);
        else if (lastname != null)
            return authorRepository.findByLastname(lastname);
        return authorRepository.findAll();
    }

    @Override
    public Author create(Author author) throws Exception {
        // Validation
        if (author.getFirstname() == null || author.getLastname() == null || author.getEmail() == null) {
            if (author.getFirstname() == null) throw new AuthorBadRequest("Firstname required");
            if (author.getLastname() == null) throw new AuthorBadRequest("Lastname required");
            if (author.getEmail() == null) throw new AuthorBadRequest("Email required");
        }
        return authorRepository.save(author);
    }

    @Override
    public Author update(Integer id, Author author) throws Exception {
        Optional<Author> dbOptionalAuthor = authorRepository.findById(id);
        if (dbOptionalAuthor.isPresent()) {
            Author dbAuthor = dbOptionalAuthor.get();
            dbAuthor.setFirstname(author.getFirstname());
            dbAuthor.setLastname(author.getLastname());
            dbAuthor.setEmail(author.getEmail());
            authorRepository.save(dbAuthor);
            return dbAuthor;
        }

        throw new Exception();
    }

    @Override
    public String delete(Integer id) throws Exception {
        if (authorRepository.findById(id).isPresent()) {
            authorRepository.deleteById(id);
            return "OK";
        }
        throw new Exception();
    }

    @Override
    public List<AuthorDTO> readAll() {
        List<AuthorDTO> dtos = new ArrayList<AuthorDTO>();
        for (Author author : authorRepository.findAll()) {
            dtos.add(modelMapper.map(author, AuthorDTO.class));
        }
        return dtos;
    }

    @Override
    public AuthorDTO readOne(Integer id) throws Exception {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) return modelMapper.map(optionalAuthor.get(), AuthorDTO.class);
        throw new AuthorNotFound();
    }

}
