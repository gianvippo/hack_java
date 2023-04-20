package it.controllertest.springbootcontroller.service;

import java.util.List;

import it.controllertest.springbootcontroller.dto.CreatePostDTO;
import it.controllertest.springbootcontroller.dto.PostDTO;

public interface PostService {
    List<PostDTO> read();
    PostDTO create(CreatePostDTO post) throws Exception;
    //Post update(Integer id, Author author) throws Exception;
    String delete(Integer id) throws Exception;
}
