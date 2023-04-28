package it.learning.learningplatform.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.learning.learningplatform.dto.CourseDTO;
import it.learning.learningplatform.dto.CreateCourseDTO;
import it.learning.learningplatform.dto.UpdateCourseDTO;
import it.learning.learningplatform.model.Course;
import it.learning.learningplatform.repository.CourseRepository;
import it.learning.learningplatform.util.exception.CourseNotFound;

@Service("courseService")
public class CourseService implements CrudService<CourseDTO, CreateCourseDTO, UpdateCourseDTO, Long> {

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
        String nameFilter = params.get("name");
        String teacherFirstnameFilter = params.get("teacherFirstname"); // il path è case sensitive
        String teacherLastnameFilter = params.get("teacherLastname");

        List<Course> courses;

        if (nameFilter != null && teacherFirstnameFilter != null && teacherLastnameFilter != null) {
            courses = courseRepository.findByNameContainingAndTeacherFirstnameContainingAndTeacherLastnameContaining(
                    nameFilter, teacherFirstnameFilter, teacherLastnameFilter);
        } else if (teacherFirstnameFilter != null && teacherLastnameFilter != null) {
            courses = courseRepository.findByTeacherFirstnameContainingAndTeacherLastnameContaining(
                    teacherFirstnameFilter, teacherLastnameFilter);
        } else if (teacherFirstnameFilter != null && nameFilter != null) {
            courses = courseRepository.findByNameContainingAndTeacherFirstnameContaining(nameFilter,
                    teacherFirstnameFilter);
        } else if (teacherLastnameFilter != null && nameFilter != null) {
            courses = courseRepository.findByNameContainingAndTeacherLastnameContaining(nameFilter,
                    teacherLastnameFilter);
        } else if (nameFilter != null) {
            courses = courseRepository.findByNameContaining(nameFilter);
        } else if (teacherFirstnameFilter != null) {
            courses = courseRepository.findByTeacherFirstnameContaining(teacherFirstnameFilter);
        } else if (teacherLastnameFilter != null) {
            courses = courseRepository.findByTeacherLastnameContaining(teacherLastnameFilter);
        } else {
            courses = courseRepository.findAll();
        }

        return courses.stream().map((c) -> mapper.map(c, CourseDTO.class)).toList();

    }

    @Override
    public CourseDTO readOne(Long id) throws Exception {
        // Optional<Course> optionalCourse = courseRepository.findById(id);
        // if (optionalCourse.isPresent()) {
        // return mapper.map(optionalCourse.get(), CourseDTO.class);
        // }
        // throw new CourseNotFound();
        return mapper.map(this.exists(id), CourseDTO.class);
    }

    @Override
    public CourseDTO create(CreateCourseDTO createDTO) {
        Course course = mapper.map(createDTO, Course.class);
        if (course.getDate() == null) {
            course.setDate(LocalDate.now());
        }
        courseRepository.save(course);
        return mapper.map(course, CourseDTO.class);
        // return mapper.map(courseRepository.save(course), CourseDTO.class);
    }

    @Override
    public CourseDTO update(Long id, UpdateCourseDTO updateDTO) throws Exception{
        Course dbCourse = this.exists(id);
        dbCourse.setDescription(updateDTO.getDescription());
        if (updateDTO.getDate() == null) dbCourse.setDate(LocalDate.now());
        else dbCourse.setDate(LocalDate.parse(updateDTO.getDate()));
        courseRepository.save(dbCourse);
        return mapper.map(dbCourse, CourseDTO.class);
        
    }

    @Override
    public String delete(Long id) throws Exception{

        // CourseDTO courseDTO = mapper.map(this.exists(id), CourseDTO.class);
        // courseRepository.deleteById(id);
        // return courseDTO;

        Course course = this.exists(id);
        CourseDTO courseDto = mapper.map(course, CourseDTO.class);
        courseRepository.delete(course);
        return "Course ID: " + id + " deleted.";

    }

    private Course exists(Long id) throws Exception {
        if (courseRepository.existsById(id)) {
            return courseRepository.findById(id).get();
        } else {
            throw new CourseNotFound();
        }
    }
}
