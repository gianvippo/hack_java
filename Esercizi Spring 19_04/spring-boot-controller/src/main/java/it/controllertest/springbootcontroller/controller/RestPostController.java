package it.controllertest.springbootcontroller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.controllertest.springbootcontroller.dto.CreatePostDTO;
import it.controllertest.springbootcontroller.dto.PostDTO;
import it.controllertest.springbootcontroller.model.Post;
import it.controllertest.springbootcontroller.repository.PostRepository;
import it.controllertest.springbootcontroller.service.PostService;

@RestController
@RequestMapping(value = "api/posts")
public class RestPostController {

    @Autowired
    private PostService postService;
    
    // rotta -> "/authors" GET
    @GetMapping
    public List<PostDTO> getAll(){
        return postService.read();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PostDTO insertPost(@RequestBody CreatePostDTO createPostDTO) throws Exception{
        return postService.create(createPostDTO);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Integer id) throws Exception {
        return postService.delete(id);
    }
}
