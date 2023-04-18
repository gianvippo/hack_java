package it.controllertest.springbootcontroller.util.mapper;

import java.util.Collection;

import org.modelmapper.AbstractConverter;

public class ConvertCollectionToInteger extends AbstractConverter<Collection<?>, Integer>{

    @Override
    protected Integer convert(Collection<?> arg0) {
        return arg0.size();
    }
    
}
