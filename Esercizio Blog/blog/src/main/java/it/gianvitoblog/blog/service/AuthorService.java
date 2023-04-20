package it.gianvitoblog.blog.service;

import java.util.List;

import it.gianvitoblog.blog.dto.AuthorDTO;
import it.gianvitoblog.blog.model.Author;

public interface AuthorService {
    List<Author> read(String firstname, String lastname);
    AuthorDTO readOne(Integer id) throws Exception;
    List<AuthorDTO> readAll();
    Author create(Author author) throws Exception;
    Author update(Integer id, Author author) throws Exception;
    String delete(Integer id) throws Exception;
}
