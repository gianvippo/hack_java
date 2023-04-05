INSERT INTO registi(nome, cognome, anno_di_nascita)
value('Stanley', 'Kubrick', 1928);

INSERT INTO registi(nome, cognome, anno_di_nascita)
value('James', 'Cameron', 1954);

INSERT INTO generi(nome)
value('dramatic');

INSERT INTO generi(nome)
value('comedy');

INSERT INTO film(nome, regista_id, anno)
value('Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb', 1, 1964);

INSERT INTO film(nome, regista_id, locandina, anno)
value('Titanic', 2, 'https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg', 1997);

INSERT INTO film(nome, regista_id, locandina, anno)
value('Titanic', 2, 'https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg', 1997);

INSERT INTO film_generi(film_id, genere_id)
value(1, 2);
INSERT INTO film_generi(film_id, genere_id)
value(1, 1);
INSERT INTO film_generi(film_id, genere_id)
value(2, 1);

-- DELETE FROM film WHERE genere = 'comedy';