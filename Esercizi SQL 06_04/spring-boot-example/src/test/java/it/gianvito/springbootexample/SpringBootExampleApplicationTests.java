package it.gianvito.springbootexample;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import it.gianvito.springbootexample.model.Prodotto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

// @SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringBootExampleApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Test
	void persistObjProdotto() {

		TypedQuery<Prodotto> q = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class);
		List<Prodotto> listProdotti = q.getResultList();

		int initialSize = listProdotti.size();

		Prodotto giubbotto = new Prodotto();
		giubbotto.setNome("Giubbotto Patagonia H2NO");
		giubbotto.setDescrizione("Giubbotto Patagonia impermeabile blu");
		giubbotto.setPrezzo(120f);

		entityManager.persist(giubbotto);

		// un persist passerà sempre un test, in questo contesto inserirà il record nel db ma realmente nel db non lo inserirà, per verificare facciamo un ulteriore passaggio

		listProdotti = q.getResultList();

		// asseriamo che la lista dei prodotti contiene un elemento in più rispetto alla lista iniziale
		Assertions.assertThat(listProdotti).hasSize(initialSize+1);
	}

	@Test
	void updateObjectProdotto() {

		TypedQuery<Prodotto> q = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class);

		List<Prodotto> listProdotto = q.getResultList();
		Prodotto p = listProdotto.get(0);

		String vecchioNome = p.getNome();
		String nome = "nuovo nome";
		String descrizione = "nuova descrizione";
		p.setNome(nome);
		p.setDescrizione(descrizione);

		entityManager.persist(p);

		listProdotto = q.getResultList();
		Assertions.assertThat(listProdotto.get(0).getNome()).isEqualTo(nome);
		Assertions.assertThat(listProdotto.get(0).getNome()).isNotEqualTo(vecchioNome);
	}

	@Test
	void removeObjectProdotto() {

		TypedQuery<Prodotto> q = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class);

		List<Prodotto> listProdotto = q.getResultList();
		Prodotto p = listProdotto.get(1);

		entityManager.remove(p);

		listProdotto = q.getResultList();
		Assertions.assertThat(p).isNotIn(listProdotto);

	}

	@Test
	void insertObjectProdotto() {

		 TypedQuery<Prodotto> q = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class);

		 Prodotto giubbotto = new Prodotto();
		 giubbotto.setNome("Giubbotto Patagonia H2NO");
		 giubbotto.setDescrizione("Giubbotto Patagonia impermeabile blu");
		 giubbotto.setPrezzo(120f);

		 entityManager.persist(giubbotto);

		 List<Prodotto> listProdotto = q.getResultList();
		 Assertions.assertThat(listProdotto.get(listProdotto.size()-1)).extracting("nome").isEqualTo(giubbotto.getNome());
		 Assertions.assertThat(listProdotto.get(listProdotto.size()-1)).extracting("descrizione").isEqualTo(giubbotto.getDescrizione());
		 Assertions.assertThat(listProdotto.get(listProdotto.size()-1)).extracting("prezzo").isEqualTo(giubbotto.getPrezzo());

		 giubbotto = new Prodotto();
		 giubbotto.setNome("Giubbotto Patagonia H2NO");
		 giubbotto.setDescrizione("Giubbotto Patagonia impermeabile blu");

		 entityManager.persist(giubbotto);

		 listProdotto = q.getResultList();
		 Assertions.assertThat(listProdotto.get(listProdotto.size()-1)).extracting("nome").isEqualTo(giubbotto.getNome());
		 Assertions.assertThat(listProdotto.get(listProdotto.size()-1)).extracting("descrizione").isEqualTo(giubbotto.getDescrizione());
		 Assertions.assertThat(listProdotto.get(listProdotto.size()-1)).extracting("prezzo").isNull();

	}

}
