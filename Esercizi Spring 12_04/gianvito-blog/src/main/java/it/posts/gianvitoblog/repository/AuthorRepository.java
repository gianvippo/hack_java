package it.posts.gianvitoblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.posts.gianvitoblog.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
    
    public List<Author> findByLastname(String lastname);

    public List<Author> findByFirstnameAndLastname(String a, String b);
    public List<Author> findByFirstnameOrLastname(String a, String b);
    // public List<Author> findByFirstnameNotIgnoreCase(String a);
}
