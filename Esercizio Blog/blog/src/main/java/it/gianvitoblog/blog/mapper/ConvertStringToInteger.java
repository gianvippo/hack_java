package it.gianvitoblog.blog.mapper;

import org.modelmapper.AbstractConverter;

public class ConvertStringToInteger extends AbstractConverter<String, Integer>{

    @Override
    protected Integer convert(String arg0) {
        return arg0.length();
    }
    
}
