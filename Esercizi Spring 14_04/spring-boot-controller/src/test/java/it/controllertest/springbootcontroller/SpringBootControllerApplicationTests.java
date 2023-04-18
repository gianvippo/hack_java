package it.controllertest.springbootcontroller;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.controllertest.springbootcontroller.model.Author;
import it.controllertest.springbootcontroller.model.Comment;
import it.controllertest.springbootcontroller.model.Post;
import it.controllertest.springbootcontroller.repository.AuthorRepository;
import it.controllertest.springbootcontroller.repository.CommentRepository;
import it.controllertest.springbootcontroller.repository.PostRepository;
import it.controllertest.springbootcontroller.service.AuthorService;

@SpringBootTest
class SpringBootControllerApplicationTests {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private AuthorService authorService;

	@BeforeEach
	public void createData(){

		commentRepository.deleteAll();
		postRepository.deleteAll();
		authorRepository.deleteAll();
		
		Author author = new Author();
		author.setFirstname("Gianvito");
		author.setLastname("Palmisano");
		author.setEmail("gp@gmail.com");

		Author author1 = new Author();
		author1.setFirstname("Giuseppe");
		author1.setLastname("Piccininni");
		author1.setEmail("pg@gmail.com");

		authorRepository.save(author1);
		authorRepository.save(author);

		Post post = new Post();
		post.setAuthor(author);
		post.setTitle("Nuovo Film di Super Mario");
		post.setBody("Film di Super Mario lorem ipsum");
		post.setPublishDate("20230412");

		postRepository.save(post);

		Post post2 = new Post();
		post2.setAuthor(author);
		post2.setTitle("Nuovo ChatGPT-4");
		post2.setBody("Intelligenza artificiale che ci seppellirà tutti");
		post2.setPublishDate("20240412");

		postRepository.save(post2);

		Comment comment = new Comment();
		comment.setEmail("franco@gmail.com");
		comment.setPost(post);
		comment.setBody("Bellissimo");
		comment.setPublishDate("20230412");

		Comment comment1 = new Comment();
		comment1.setEmail("giuseppe@gmail.com");
		comment1.setPost(post);
		comment1.setBody("Carino ma non troppo");
		comment1.setPublishDate("20220412");

		commentRepository.save(comment);
		commentRepository.save(comment1);

	}

	@Test
	void findGianvito() {

		List<Post> posts = postRepository.findByAuthorWithFirstNameGianvito();
		assertThat(posts).hasSize(2);
		assertThat(posts.get(0)).extracting("author").extracting("lastname").isEqualTo("Palmisano");

		List<Post> posts1 = postRepository.findByAuthorFirstName("Piccininni");
		assertThat(posts1).hasSize(0);

	}

	@Test
	void deleteFrancoComment(){
		assertThat(commentRepository.count()).isEqualTo(2);
		commentRepository.deleteFranco();
		assertThat(commentRepository.findAll()).asList().hasSize(1);
	}

	@Test
	void testTransaction(){

		try {
			authorService.transaction();
		} catch (Exception e) {
			assertThat(postRepository.findByAuthorFirstName("null")).hasSize(0);
			assertThat(authorRepository.findByFirstnameAndLastname("null", "null")).hasSize(0);
		}

	}

}
