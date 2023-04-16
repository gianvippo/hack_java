package it.posts.gianvitoblog;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order.Direction;

import it.posts.gianvitoblog.model.Author;
import it.posts.gianvitoblog.model.Comment;
import it.posts.gianvitoblog.model.Post;
import it.posts.gianvitoblog.repository.AuthorRepository;
import it.posts.gianvitoblog.repository.CommentRepository;
import it.posts.gianvitoblog.repository.CrudAuthorRepository;
import it.posts.gianvitoblog.repository.PagingAndSortingAuthorRepository;
import it.posts.gianvitoblog.repository.PostRepository;
import jakarta.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class GianvitoBlogApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private CrudAuthorRepository crudAuthorRepository;

	@Autowired
	private PagingAndSortingAuthorRepository pagingAndSortingAuthorRepository;

	@BeforeEach
	public void createData(){
		Author author = new Author();
		author.setFirstname("Gianvito");
		author.setLastname("Palmisano");
		author.setEmail("gp@gmail.com");

		Author author1 = new Author();
		author1.setFirstname("Giuseppe");
		author1.setLastname("Piccininni");
		author1.setEmail("pg@gmail.com");

		entityManager.persist(author1);
		entityManager.persist(author);

		Post post = new Post();
		post.setAuthor(author);
		post.setTitle("Nuovo Film di Super Mario");
		post.setBody("Film di Super Mario lorem ipsum");
		post.setPublishDate("20230412");

		entityManager.persist(post);

		Post post2 = new Post();
		post2.setAuthor(author);
		post2.setTitle("Nuovo ChatGPT-4");
		post2.setBody("Intelligenza artificiale che ci seppellirà tutti");
		post2.setPublishDate("20240412");

		entityManager.persist(post2);

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

		entityManager.persist(comment);
		entityManager.persist(comment1);


	}

	@Test
	void authorCheck() {

		List<Author> authors = entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultList();
		assertThat(authors).asList().hasSize(2);

		assertThat(pagingAndSortingAuthorRepository.findAll(Sort.by("lastname"))).extracting("lastname").contains("Palmisano", "Piccininni");
		assertThat(pagingAndSortingAuthorRepository.findAll(Sort.by("lastname"))).extracting("lastname").contains("Palmisano", atIndex(0));

	}

	@Test
	void postCheck() {

		List<Post> posts = entityManager.createQuery("SELECT a FROM Post a", Post.class).getResultList();
		assertThat(posts).asList().hasSize(2);

	}

	@Test
	void commentCheck() {

		// estraiamo tutti i post e controlliamo che a un post stiano il numero di tot commenti

		List<Post> posts = entityManager.createQuery("SELECT a FROM Post a", Post.class).getResultList();
		List<Comment> commentsPost1 = entityManager
		.createQuery("SELECT c FROM Comment c WHERE c.post.id = ?1", Comment.class)
		.setParameter(1, posts.get(0).getId())
		.getResultList();

		List<Comment> commentsPost2 = entityManager
		.createQuery("SELECT c FROM Comment c WHERE c.post.id = ?1", Comment.class)
		.setParameter(1, posts.get(1).getId())
		.getResultList();
		
		assertThat(commentsPost1).asList().hasSize(2);
		assertThat(commentsPost2).asList().hasSize(0);
		
	}


	@Test
	void authorRepositoryCheck(){
		
		assertThat(authorRepository.count()).isEqualTo(2);
		assertThat(authorRepository.findAll()).asList().hasSize(2);
		assertThat(authorRepository.findAll()).first().extracting("firstname").isEqualTo("Giuseppe");

		Author author = authorRepository.findAll().get(0);
		assertThat(authorRepository.findById(author.getId())).get().extracting("lastname").isEqualTo("Piccininni");

	}

	@Test
	void findByLastname(){
		assertThat(authorRepository.findByLastname("Palmisano")).first().extracting("lastname").isEqualTo("Palmisano");
	}

	@Test
	void findByFirstnameAndLastname(){
		assertThat(authorRepository.findByFirstnameAndLastname("Gianvito", "Palmisano")).first().extracting("lastname").isEqualTo("Palmisano");
		assertThat(authorRepository.findByFirstnameAndLastname("Gianvito", "Piccininni")).isNullOrEmpty();
	}

	@Test
	void findByFirstnameOrLastname(){
		assertThat(authorRepository.findByFirstnameOrLastname("Gianvito", "Piccininni")).asList().hasSize(2);
	}

	// @Test
	// void notIgnoreCase(){
	// 	assertThat(authorRepository.findByFirstnameNotIgnoreCase("gianvito")).asList().hasSize(0);
	// 	assertThat(authorRepository.findByFirstnameNotIgnoreCase("Gianvito")).asList().hasSize(0);
	// }

	@Test
	void createCrud(){
		Author a = new Author();
		a.setFirstname("Franco");
		a.setLastname("Rossi");
		a.setEmail("fr@gmail.com");

		crudAuthorRepository.save(a);
		assertThat(crudAuthorRepository.findAll()).asList().hasSize(3);
	}

	@Test
	void createJpa(){
		Author a = new Author();
		a.setFirstname("Franco");
		a.setLastname("Rossi");
		a.setEmail("fr@gmail.com");

		authorRepository.save(a);
		assertThat(authorRepository.findAll()).asList().hasSize(3);
	}

	@Test
	void sorting(){
		assertThat(pagingAndSortingAuthorRepository.findAll(Sort.by("lastname"))).first().extracting("lastname").isEqualTo("Palmisano"); 
	}

	@Test
	void paging(){
		authorRepository.deleteAll();
		for(int i = 0; i < 100; i++){
			Author a = new Author();
			a.setFirstname(String.valueOf(i));
			a.setLastname(String.valueOf(i));
			a.setEmail(String.valueOf(i));

			authorRepository.save(a);
		}

		assertThat(authorRepository.findAll()).hasSize(100);

		assertThat(authorRepository.count()).isEqualTo(100);	// -> PIU' VELOCE SE SONO PRESENTI MOLTI DATI

		int pageSize = 10;
		assertThat(pagingAndSortingAuthorRepository
		.findAll(PageRequest.of(0, pageSize)))
		.extracting("firstname")
		.contains("0", atIndex(0))
		.contains("1", atIndex(1));

		assertThat(pagingAndSortingAuthorRepository
		.findAll(PageRequest.of(1, pageSize)))
		.extracting("firstname")
		.contains("10", atIndex(0))
		.contains("11", atIndex(1));

		assertThat(pagingAndSortingAuthorRepository
		.findAll(PageRequest.of(9, pageSize)))
		.extracting("firstname")
		.contains("99", atIndex(9))
		.contains("98", atIndex(8));
	}

	@Test
	void findByTitle(){
		assertThat(postRepository.findByTitle("Nuovo Film di Super Mario")).first().extracting("title").asString().contains("Mario");
	}

	@Test
	void findByEmailOrDate(){
		assertThat(commentRepository.findByEmailOrPublishDate("giuseppe@gmail.com", "20230412")).asList().hasSize(2);
	}

	@Test
	void sortingPost(){
		assertThat(postRepository.findAll(Sort.by("title"))).first().extracting("publishDate").isEqualTo("20240412"); 
	}

	@Test
	void sortingComment(){
		assertThat(commentRepository.findAll(Sort.by("email", "publishDate")).get(1)).extracting("email").isEqualTo("giuseppe@gmail.com");
	}

	@Test
	void pagingCommenti(){
		commentRepository.deleteAll();
		for(int i = 0; i < 1000; i++){
			Comment c = new Comment();
			c.setBody(String.valueOf(i));
			c.setEmail(String.valueOf(i));

			commentRepository.save(c);
		}

		assertThat(commentRepository.findAll()).hasSize(1000);

		assertThat(commentRepository.count()).isEqualTo(1000);	// -> PIU' VELOCE SE SONO PRESENTI MOLTI DATI

		int pageSize = 10;
		assertThat(commentRepository
		.findAll(PageRequest.of(12, pageSize)))
		.extracting("body")
		.contains("124", atIndex(4));
	}

	@Test
	void checkPartialEmail(){
		assertThat(authorRepository.findSomething("gmail.com")).asList().hasSize(2);
	}
}
