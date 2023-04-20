package it.gianvitoblog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.gianvitoblog.blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
}
