package it.posts.gianvitoblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.posts.gianvitoblog.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

    public List<Post> findByTitle(String a);
    
}
