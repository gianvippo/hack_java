package it.posts.gianvitoblog.repository;

import org.springframework.data.repository.CrudRepository;

import it.posts.gianvitoblog.model.Author;

public interface CrudAuthorRepository extends CrudRepository<Author, Integer>{
    
}
