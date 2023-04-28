package it.learning.learningplatform;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.learning.learningplatform.util.mapping.CourseToCourseDtoPropertyMap;
import it.learning.learningplatform.util.mapping.CreateCourseDTOToCoursePropertyMap;

@SpringBootApplication
public class LearningPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningPlatformApplication.class, args);
	}

	@Bean
	public ModelMapper instanceModelMapper() {		// SINGLETON
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new CreateCourseDTOToCoursePropertyMap());
		mapper.addMappings(new CourseToCourseDtoPropertyMap());
		return mapper;
	}
}
