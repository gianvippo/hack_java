package it.controllertest.springbootcontroller.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.controllertest.springbootcontroller.dto.CreatePostDTO;
import it.controllertest.springbootcontroller.dto.PostDTO;
import it.controllertest.springbootcontroller.model.Post;
import it.controllertest.springbootcontroller.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PostDTO> read() {
        List<PostDTO> dtos = new ArrayList<PostDTO>();
        for(Post p : postRepository.findAll()){
            PostDTO map = modelMapper.map(p, PostDTO.class);
            dtos.add(map);
        }

        return dtos;
    }

    @Override
    public PostDTO create(CreatePostDTO post) {
        Post p = modelMapper.map(post, Post.class);
        p = postRepository.save(p);
        p = postRepository.findById(p.getId()).get();
        return modelMapper.map(p, PostDTO.class);
    }

    @Override
    public String delete(Integer id) throws Exception {
        if (postRepository.findById(id).isPresent()) {
            postRepository.deleteById(id);
            return "OK";
        }
        throw new Exception();
    }

    
    
}
