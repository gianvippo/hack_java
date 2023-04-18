package it.controllertest.springbootcontroller.util.mapper;

import org.modelmapper.PropertyMap;

import it.controllertest.springbootcontroller.dto.AuthorDTO;
import it.controllertest.springbootcontroller.model.Author;

public class AuthorToAuthorDTOPropertyMapper extends PropertyMap<Author, AuthorDTO>{

    @Override
    protected void configure() {
        using(new ConvertCollectionToInteger()).map(source.getPosts()).setNumberOfPost(null);
    }
    
}
