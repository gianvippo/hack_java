package it.controllertest.springbootcontroller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.controllertest.springbootcontroller.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
    
    @Query("SELECT p FROM Post p WHERE p.author.firstname = 'Gianvito'")
    List<Post> findByAuthorWithFirstNameGianvito();

    @Query("SELECT p FROM Post p WHERE p.author.firstname = ?1")
    List<Post> findByAuthorFirstName(String firstname);

    // @Query("SELECT p FROM Post p WHERE p.author.firstname = :firstname")
    // List<Post> findByAuthorFirstNameParam(@Param("firstname") String firstname);

}
