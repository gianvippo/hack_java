package it.posts.gianvitoblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.posts.gianvitoblog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
    public List<Comment> findByEmailOrPublishDate(String a, String b);
}
