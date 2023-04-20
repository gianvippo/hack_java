package it.controllertest.springbootcontroller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.controllertest.springbootcontroller.model.Comment;
import it.controllertest.springbootcontroller.repository.CommentRepository;

@RestController
@RequestMapping(value = "api/comments")
public class RestCommentController {
    
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<Comment> getAll(){
        return commentRepository.findAll();
    }
}
