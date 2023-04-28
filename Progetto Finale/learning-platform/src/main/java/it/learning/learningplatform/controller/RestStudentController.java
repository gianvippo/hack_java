package it.learning.learningplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.learning.learningplatform.model.Course;
import it.learning.learningplatform.model.Student;
import it.learning.learningplatform.repository.CourseRepository;
import it.learning.learningplatform.repository.StudentRepository;

@RestController
@RequestMapping("api/students")
public class RestStudentController {
    
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("{id}/{idCourse}")
    public Student addCourse(@PathVariable("id") Long id, @PathVariable("idCourse") Long idCourse)
            throws Exception {
        Student student = studentRepository.findById(id).get();
        Course course = courseRepository.findById(idCourse).get();

        course.getStudents().add(student);
        courseRepository.save(course);

        return studentRepository.findById(id).get();              
    }
}
