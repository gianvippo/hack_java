package it.learning.learningplatform.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.learning.learningplatform.dto.CourseDTO;
import it.learning.learningplatform.dto.CreateCourseDTO;
import it.learning.learningplatform.dto.UpdateCourseDTO;
import it.learning.learningplatform.model.Course;
import it.learning.learningplatform.repository.CourseRepository;

@Service("courseService")
public class CourseService implements CrudService<CourseDTO, CreateCourseDTO, UpdateCourseDTO, Long>{

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseDTO> readAll() {
        List<CourseDTO> dtos = new ArrayList<CourseDTO>();
        for (Course c : courseRepository.findAll()) {
            dtos.add(mapper.map(c, CourseDTO.class));
        }
        return dtos;
    }

    @Override
    public List<CourseDTO> read(Map<String, String> params) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public List<CourseDTO> readOne(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readOne'");
    }

    @Override
    public CourseDTO create(CreateCourseDTO createDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public CourseDTO update(UpdateCourseDTO updateDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public CourseDTO delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
