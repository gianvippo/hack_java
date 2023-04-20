package it.learning.learningplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.learning.learningplatform.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
