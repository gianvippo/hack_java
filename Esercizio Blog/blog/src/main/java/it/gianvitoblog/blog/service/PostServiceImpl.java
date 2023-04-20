package it.gianvitoblog.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.gianvitoblog.blog.dto.CreatePostDTO;
import it.gianvitoblog.blog.dto.PostDTO;
import it.gianvitoblog.blog.model.Author;
import it.gianvitoblog.blog.model.Post;
import it.gianvitoblog.blog.repository.AuthorRepository;
import it.gianvitoblog.blog.repository.PostRepository;
import it.gianvitoblog.blog.util.exception.AuthorNotFound;
import it.gianvitoblog.blog.util.exception.PostNotFound;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<PostDTO> readAll() {
        List<PostDTO> dtos = new ArrayList<PostDTO>();
        for(Post p : postRepository.findAll()){
            PostDTO map = modelMapper.map(p, PostDTO.class);
            dtos.add(map);
        }

        return dtos;
    }

    @Override
    public PostDTO create(CreatePostDTO post) throws Exception {
        Post p = modelMapper.map(post, Post.class);
        p = postRepository.save(p);
        Optional<Author> optionalAuthor = authorRepository.findById(post.getAuthorId());
        if (optionalAuthor.isPresent()) {
            p.setAuthor(optionalAuthor.get());
            return modelMapper.map(p, PostDTO.class);
        }
        throw new AuthorNotFound();
    }

    @Override
    public String delete(Integer id) throws Exception {
        if (postRepository.findById(id).isPresent()) {
            postRepository.deleteById(id);
            return "OK";
        }
        throw new PostNotFound();
    }
    
}
