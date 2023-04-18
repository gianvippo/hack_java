package it.controllertest.springbootcontroller;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.controllertest.springbootcontroller.dto.CreatePostDTO;
import it.controllertest.springbootcontroller.model.Post;

@SpringBootApplication
public class SpringBootControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootControllerApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper mapper = new ModelMapper();
		PropertyMap<CreatePostDTO, Post> createPostDtoToPostMapping = new PropertyMap<CreatePostDTO,Post>() {
			protected void configure(){
				map().setId(null);
				map().getAuthor().setId(source.getAuthorId());;

			}
		};
		mapper.addMappings(createPostDtoToPostMapping);
		return mapper;
	}

}
