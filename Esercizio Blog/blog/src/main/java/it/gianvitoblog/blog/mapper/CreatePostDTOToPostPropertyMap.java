package it.gianvitoblog.blog.mapper;

import org.modelmapper.PropertyMap;

import it.gianvitoblog.blog.dto.CreatePostDTO;
import it.gianvitoblog.blog.dto.PostDTO;
import it.gianvitoblog.blog.model.Post;

public class CreatePostDTOToPostPropertyMap extends PropertyMap<CreatePostDTO, Post>{

    @Override
    protected void configure() {
        map().setId(null);
		map().getAuthor().setId(source.getAuthorId());
    }
    
}
