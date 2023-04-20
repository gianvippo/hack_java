package it.learning.learningplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.learning.learningplatform.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long>{
    
}
