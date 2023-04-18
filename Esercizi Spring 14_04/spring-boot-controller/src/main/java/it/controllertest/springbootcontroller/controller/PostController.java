package it.controllertest.springbootcontroller.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.controllertest.springbootcontroller.dto.CreatePostDTO;
import it.controllertest.springbootcontroller.dto.PostDTO;
import it.controllertest.springbootcontroller.model.Post;
import it.controllertest.springbootcontroller.repository.PostRepository;
import it.controllertest.springbootcontroller.service.PostService;

@Controller
@RequestMapping(value = "posts")
public class PostController {

    @Autowired
    private PostService postService;
    
    // rotta -> "/authors" GET
    @GetMapping
    public @ResponseBody List<PostDTO> getAll(){
        return postService.read();
    }

    @PostMapping
    public @ResponseBody PostDTO insertPost(@RequestBody CreatePostDTO createPostDTO){
        return postService.create(createPostDTO);
    }

    @DeleteMapping("{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id) throws Exception {
        return postService.delete(id);
    }
}
