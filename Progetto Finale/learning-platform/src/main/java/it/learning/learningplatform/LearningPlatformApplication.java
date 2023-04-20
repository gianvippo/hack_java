package it.learning.learningplatform;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningPlatformApplication.class, args);
	}

	@Bean
	public ModelMapper instanceModelMapper() {		// SINGLETON
		ModelMapper mapper = new ModelMapper();

		return mapper;
	}
}
