package it.movie.springdb;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import it.movie.springdb.model.Film;
import it.movie.springdb.model.Genere;
import it.movie.springdb.model.Regista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringDbApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Test
	void persistObjectFilm() {

		TypedQuery<Film> q = entityManager.createQuery("SELECT f FROM Film f", Film.class);
		TypedQuery<Regista> q1 = entityManager.createQuery("SELECT r FROM Regista r WHERE id = 1", Regista.class);

		Film film = new Film();
		film.setNome("The Shining");
		film.setRegista(q1.getSingleResult());
		film.setAnno(1980);

		List<Film> list = q.getResultList();
		Assertions.assertThat(list).hasSize(3);
		entityManager.persist(film);
		list = q.getResultList();
		Assertions.assertThat(list).hasSize(4);

	}

	@Test
	void checkAnno(){

		TypedQuery<Regista> q1 = entityManager.createQuery("SELECT r FROM Regista r WHERE id = 1", Regista.class);

		Film film = new Film();

		film.setNome("The Shining");
		film.setRegista(q1.getSingleResult());
		film.setAnno(1980);

		entityManager.persist(film);

		TypedQuery<Film> q = entityManager.createQuery("SELECT f FROM Film f WHERE id = " + film.getId(), Film.class);
		Film filmDB = q.getSingleResult();

		Assertions.assertThat(filmDB).extracting("anno").isEqualTo(1980);

	}

	@Test
	void checkNomeRegista(){

		TypedQuery<Film> q = entityManager.createQuery("SELECT f FROM Film f WHERE id = 1", Film.class);

		Film filmDB = q.getSingleResult();

		Assertions.assertThat(filmDB).extracting("regista").extracting("nome").isEqualTo("Stanley");
		Assertions.assertThat(filmDB).extracting("regista").extracting("nome").isNotEqualTo("James");

	}

	@Test
	void checkNumeroFilmKubrick(){
		TypedQuery<Regista> q = entityManager.createQuery("SELECT r FROM Regista r WHERE id = 1", Regista.class);
		Regista kubrick = q.getSingleResult();

		Assertions.assertThat(kubrick).extracting("listFilm").asList().hasSize(1);
	}

	@Test
	void checkFilmDaGenere(){
		TypedQuery<Genere> q = entityManager.createQuery("SELECT g FROM Genere g", Genere.class);
		List<Genere> listGeneri = q.getResultList();

		Assertions.assertThat(listGeneri.get(0)).extracting("film").asList().hasSize(2);
		Assertions.assertThat(listGeneri.get(1)).extracting("film").asList().hasSize(1);
	}

	@Test
	void checkGenereDaFilm(){
		TypedQuery<Film> q = entityManager.createQuery("SELECT f FROM Film f WHERE id = 1", Film.class);
		Film f = q.getSingleResult();

		Assertions.assertThat(f).extracting("generi").asList().hasSize(2);

	}

	@Test
	void checkDeleteRelation(){

		TypedQuery<Genere> q = entityManager.createQuery("SELECT g FROM Genere g WHERE id = 1", Genere.class);
		Genere g = q.getSingleResult();
		TypedQuery<Regista> q1 = entityManager.createQuery("SELECT r FROM Regista r WHERE id = 1", Regista.class);

		Film film = new Film();

		film.setNome("The Shining");
		film.setRegista(q1.getSingleResult());
		film.setAnno(1980);
		
		entityManager.persist(film);

		// aggiungiamo al genere 1 il film che abbiamo creato
		g.getFilm().add(film);

		entityManager.persist(g);

		q = entityManager.createQuery("SELECT g FROM Genere g", Genere.class);
		List<Genere> listGeneri = q.getResultList();

		Assertions.assertThat(listGeneri.get(0)).extracting("film").asList().hasSize(3);

		// entityManager.remove(film);
		// listGeneri = q.getResultList();
		// Assertions.assertThat(listGeneri.get(0)).extracting("film").asList().hasSize(2);

		entityManager.remove(g);
		TypedQuery<Film> queryFilm = entityManager.createQuery("SELECT f FROM Film f WHERE id = " + film.getId(), Film.class);
		Film filmQ = queryFilm.getSingleResult();

		Assertions.assertThat(filmQ).extracting("generi").asList().isEmpty();

	}

}
