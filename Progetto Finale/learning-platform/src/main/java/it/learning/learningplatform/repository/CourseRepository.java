package it.learning.learningplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.learning.learningplatform.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
