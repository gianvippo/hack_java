package it.gianvitoblog.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.gianvitoblog.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

    @Query("SELECT p FROM Post p WHERE p.author.firstname = 'Gianvito'")
    List<Post> findByAuthorWithFirstNameGianvito();

    @Query("SELECT p FROM Post p WHERE p.author.firstname = ?1")
    List<Post> findByAuthorFirstName(String firstname);

}
