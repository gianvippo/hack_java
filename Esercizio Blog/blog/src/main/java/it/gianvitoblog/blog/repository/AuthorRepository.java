package it.gianvitoblog.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.gianvitoblog.blog.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
    public List<Author> findByLastname(String lastname);
    public List<Author> findByFirstname(String s);
    public List<Author> findByFirstnameAndLastname(String a, String b);
    public List<Author> findByFirstnameOrLastname(String a, String b);
}
