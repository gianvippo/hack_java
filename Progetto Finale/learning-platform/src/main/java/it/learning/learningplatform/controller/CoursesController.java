package it.learning.learningplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.learning.learningplatform.dto.CourseDTO;
import it.learning.learningplatform.dto.CreateCourseDTO;
import it.learning.learningplatform.dto.UpdateCourseDTO;
import it.learning.learningplatform.repository.StudentRepository;
import it.learning.learningplatform.service.CrudService;

@Controller
@RequestMapping(value = "courses")
public class CoursesController {

    @Autowired
    private CrudService<CourseDTO, CreateCourseDTO, UpdateCourseDTO, Long> courseService;

    @Autowired
    private StudentRepository studentRepository;
    
    @GetMapping
    public String listView(Model model) {
        model.addAttribute("title", "Learning Platform - Courses");
        model.addAttribute("courses", courseService.readAll());
        return "courses/index";
    }

    @GetMapping("{id}")
    public String modifyCourseView(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("title", "Learning Platform - Course");
        model.addAttribute("course", courseService.readOne(id));
        model.addAttribute("students", studentRepository.findAll());
        return "courses/edit";
    }

    @PostMapping("update")
    public String saveCourse(@ModelAttribute("course") UpdateCourseDTO updateCourseDTO) throws Exception {
        courseService.update(updateCourseDTO.getId(), updateCourseDTO);
        return "redirect:/courses";
    }

}
