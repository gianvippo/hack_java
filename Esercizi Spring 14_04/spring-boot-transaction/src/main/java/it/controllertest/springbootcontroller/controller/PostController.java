package it.controllertest.springbootcontroller.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.controllertest.springbootcontroller.dto.CreatePostDTO;
import it.controllertest.springbootcontroller.dto.PostDTO;
import it.controllertest.springbootcontroller.model.Post;
import it.controllertest.springbootcontroller.repository.PostRepository;

@Controller
@RequestMapping(value = "posts")
public class PostController {
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    // rotta -> "/authors" GET
    @GetMapping
    public @ResponseBody List<PostDTO> getAll(){
        List<PostDTO> dtos = new ArrayList<PostDTO>();
        for(Post p : postRepository.findAll()){
            PostDTO map = modelMapper.map(p, PostDTO.class);
            dtos.add(map);
        }
        return dtos;
    }

    @PostMapping
    public @ResponseBody PostDTO create(@RequestBody CreatePostDTO createPostDTO){
        Post p = modelMapper.map(createPostDTO, Post.class);
        p = postRepository.save(p);
        p = postRepository.findById(p.getId()).get();
        return modelMapper.map(p, PostDTO.class);
    }
}
