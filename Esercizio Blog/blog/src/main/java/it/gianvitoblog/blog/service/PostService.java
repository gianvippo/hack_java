package it.gianvitoblog.blog.service;

import java.util.List;

import it.gianvitoblog.blog.dto.CreatePostDTO;
import it.gianvitoblog.blog.dto.PostDTO;

public interface PostService {
    List<PostDTO> readAll();
    PostDTO create(CreatePostDTO post) throws Exception;
    String delete(Integer id) throws Exception;
}
