package it.learning.learningplatform.util.mapping;

import org.modelmapper.PropertyMap;

import it.learning.learningplatform.dto.CourseDTO;
import it.learning.learningplatform.model.Course;

public class CourseToCourseDtoPropertyMap extends PropertyMap<Course, CourseDTO> {

    @Override
    protected void configure() {
        using(new ConvertCollectionToInteger()).map(source.getStudents()).setNumberOfStudents(null);
    }
    
}
