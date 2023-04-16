package it.posts.gianvitoblog.repository;

import java.util.List;

import it.posts.gianvitoblog.model.Author;

public interface BlogAuthorRepository {
    
    List<Author> findSomething (String partialEmail);

}
