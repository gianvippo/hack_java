package it.posts.gianvitoblog.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.posts.gianvitoblog.model.Author;
import jakarta.persistence.EntityManager;

@Repository
public class BlogAuthorRepositoryImpl implements BlogAuthorRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Author> findSomething(String partialEmail) {
        
        // entityManager.createQuery("SELECT a FROM Author a WHERE a.email LIKE '%" + partialEmail + "%'");
        
        return entityManager.createQuery("SELECT a FROM Author a WHERE a.email LIKE :partialEmail", Author.class).setParameter("partialEmail", "%" + partialEmail + "%").getResultList();
    }
    
}
