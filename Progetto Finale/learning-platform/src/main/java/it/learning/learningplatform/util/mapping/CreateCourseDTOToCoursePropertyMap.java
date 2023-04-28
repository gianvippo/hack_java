package it.learning.learningplatform.util.mapping;

import org.modelmapper.PropertyMap;

import it.learning.learningplatform.dto.CreateCourseDTO;
import it.learning.learningplatform.model.Course;

public class CreateCourseDTOToCoursePropertyMap extends PropertyMap<CreateCourseDTO, Course>{

    @Override
    protected void configure() {
        using(new ConvertStringToDate()).map(source.getDate()).setDate(null);
    }
    
}
