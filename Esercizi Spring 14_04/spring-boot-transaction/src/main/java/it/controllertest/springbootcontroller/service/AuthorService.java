package it.controllertest.springbootcontroller.service;

import java.util.List;

import it.controllertest.springbootcontroller.model.Author;

public interface AuthorService {
    List<Author> read(String firstname, String lastname);
    Author create(Author author);
    Author update(Integer id, Author author) throws Exception;
    String delete(Integer id) throws Exception;
    void transaction();
    void noTransaction();
}
