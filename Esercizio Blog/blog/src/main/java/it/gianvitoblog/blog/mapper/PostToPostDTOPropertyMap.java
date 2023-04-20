package it.gianvitoblog.blog.mapper;

import org.modelmapper.PropertyMap;

import it.gianvitoblog.blog.dto.PostDTO;
import it.gianvitoblog.blog.model.Post;

public class PostToPostDTOPropertyMap extends PropertyMap<Post, PostDTO>{

    @Override
    protected void configure() {
        using(new ConvertStringToInteger()).map(source.getBody()).setBodyLenght(null);
    }
    
}
