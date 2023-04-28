package it.learning.learningplatform.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("all")
    public List<CourseDTO> getAll() {
        return crudService.readAll();
    }

    @GetMapping
    public List<CourseDTO> get(@RequestParam Map<String, String> params) {
        return crudService.read(params);
    }

    @GetMapping("{id}")
    public CourseDTO getOne(@PathVariable("id") Long id) throws Exception{
        return crudService.readOne(id);
    }

    @PostMapping
    public CourseDTO insertCourse(@RequestBody CreateCourseDTO courseDTO){
        return crudService.create(courseDTO);
    }

    @PutMapping("{id}")
    public CourseDTO modifyCourse(@PathVariable("id") Long id, @RequestBody UpdateCourseDTO updateCourseDTO) throws Exception {
        return crudService.update(id, updateCourseDTO);
    }

    @DeleteMapping("{id}")
    public String deleteCourse(@PathVariable("id") Long id) throws Exception{
        return crudService.delete(id);
    }
}
