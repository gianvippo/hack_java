package it.controllertest.springbootcontroller.service;

import java.util.List;

import it.controllertest.springbootcontroller.dto.AuthorDTO;
import it.controllertest.springbootcontroller.model.Author;

public interface AuthorService {
    List<Author> read(String firstname, String lastname);
    AuthorDTO readOne(Integer id) throws Exception;
    List<AuthorDTO> readAll();
    Author create(Author author) throws Exception;
    Author update(Integer id, Author author) throws Exception;
    String delete(Integer id) throws Exception;
    void transaction();
    void noTransaction();
}
