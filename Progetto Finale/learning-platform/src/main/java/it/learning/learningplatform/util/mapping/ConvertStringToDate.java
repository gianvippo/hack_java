package it.learning.learningplatform.util.mapping;

import java.time.LocalDate;

import org.modelmapper.AbstractConverter;

public class ConvertStringToDate extends AbstractConverter<String, LocalDate>{

    @Override
    protected LocalDate convert(String arg0) {
        return LocalDate.parse(arg0);
    }
    
}
