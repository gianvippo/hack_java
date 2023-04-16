package it.controllertest.springbootcontroller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.controllertest.springbootcontroller.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
    
    public List<Author> findByLastname(String lastname);
    public List<Author> findByFirstnameAndLastname(String a, String b);
    public List<Author> findByFirstnameOrLastname(String a, String b);
}
