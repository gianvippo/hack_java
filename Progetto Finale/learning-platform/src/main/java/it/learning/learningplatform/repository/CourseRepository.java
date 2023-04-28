package it.learning.learningplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.learning.learningplatform.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/

    List<Course> findByNameContaining(String name);

    List<Course> findByTeacherFirstnameContaining(String firstname); // Trova il firstname direttamente dall'embedded

    List<Course> findByTeacherLastnameContaining(String lastname);

    List<Course> findByNameContainingAndTeacherFirstnameContaining(String name, String teacherFirstname);

    List<Course> findByNameContainingAndTeacherLastnameContaining(String name, String teacherFirstname);

    List<Course> findByTeacherFirstnameContainingAndTeacherLastnameContaining(String firstname,
            String teacherFirstname);

    List<Course> findByNameContainingAndTeacherFirstnameContainingAndTeacherLastnameContaining(String name,
            String firstname,
            String teacherFirstname);
}
