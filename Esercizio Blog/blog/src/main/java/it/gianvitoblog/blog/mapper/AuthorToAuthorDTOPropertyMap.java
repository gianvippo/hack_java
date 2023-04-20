package it.gianvitoblog.blog.mapper;

import org.modelmapper.PropertyMap;

import it.gianvitoblog.blog.dto.AuthorDTO;
import it.gianvitoblog.blog.model.Author;

public class AuthorToAuthorDTOPropertyMap extends PropertyMap<Author, AuthorDTO>{

    @Override
    protected void configure() {
        using(new ConvertCollectionToInteger()).map(source.getPosts()).setNumberOfPost(null);
    }
    
}
