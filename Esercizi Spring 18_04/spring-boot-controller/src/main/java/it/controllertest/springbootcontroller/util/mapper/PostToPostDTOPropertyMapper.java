package it.controllertest.springbootcontroller.util.mapper;

import org.modelmapper.PropertyMap;

import it.controllertest.springbootcontroller.dto.PostDTO;
import it.controllertest.springbootcontroller.model.Post;

public class PostToPostDTOPropertyMapper extends PropertyMap<Post, PostDTO> {

    @Override
    protected void configure() {
        using(new ConvertStringToInteger()).map(source.getBody()).setBodyLenght(null);
    }
    
}
