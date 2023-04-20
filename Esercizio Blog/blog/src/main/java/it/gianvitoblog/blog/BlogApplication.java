package it.gianvitoblog.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.gianvitoblog.blog.mapper.AuthorToAuthorDTOPropertyMap;
import it.gianvitoblog.blog.mapper.CreatePostDTOToPostPropertyMap;
import it.gianvitoblog.blog.mapper.PostToPostDTOPropertyMap;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper mapper = new ModelMapper();

		CreatePostDTOToPostPropertyMap createPostDTOToPostPropertyMap = new CreatePostDTOToPostPropertyMap();
		AuthorToAuthorDTOPropertyMap authorDTOPropertyMap = new AuthorToAuthorDTOPropertyMap();
		PostToPostDTOPropertyMap postDTOPropertyMap = new PostToPostDTOPropertyMap();
		
		mapper.addMappings(createPostDTOToPostPropertyMap);
		mapper.addMappings(authorDTOPropertyMap);
		mapper.addMappings(postDTOPropertyMap);
		return mapper;
	}

}
