package it.learning.learningplatform.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.learning.learningplatform.dto.CourseDTO;
import it.learning.learningplatform.dto.CreateCourseDTO;
import it.learning.learningplatform.dto.UpdateCourseDTO;
import it.learning.learningplatform.service.CrudService;

@RestController
@RequestMapping("api/courses")
public class RestCourseController {
    
    @Autowired
    private CrudService<CourseDTO, CreateCourseDTO, UpdateCourseDTO, Long> crudService;

    @GetMapping
    public List<CourseDTO> get(@RequestParam Map<String, String> params) {
        return crudService.readAll();
    }
}
