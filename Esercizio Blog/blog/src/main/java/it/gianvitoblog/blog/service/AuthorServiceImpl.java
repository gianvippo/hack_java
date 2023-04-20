package it.gianvitoblog.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.gianvitoblog.blog.dto.AuthorDTO;
import it.gianvitoblog.blog.model.Author;
import it.gianvitoblog.blog.repository.AuthorRepository;
import it.gianvitoblog.blog.util.exception.AuthorBadRequest;
import it.gianvitoblog.blog.util.exception.AuthorNotFound;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ModelMapper modelMapper;

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
    public AuthorDTO readOne(Integer id) throws Exception {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) return modelMapper.map(optionalAuthor.get(), AuthorDTO.class);
        throw new AuthorNotFound();
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

        throw new AuthorNotFound();
    }

    @Override
    public String delete(Integer id) throws Exception {
        if (authorRepository.findById(id).isPresent()) {
            authorRepository.deleteById(id);
            return "OK";
        }
        throw new AuthorNotFound();
    }
    
}
