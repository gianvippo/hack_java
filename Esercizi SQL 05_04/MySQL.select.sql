-- SELECT * FROM film JOIN registi on registi.id = film.regista_id;

-- SELECT f.nome, g.nome
-- FROM generi g
-- JOIN film_generi fg on g.id = fg.film_id
-- JOIN film f on f.id = fg.genere_id
-- WHERE f.nome LIKE ('%Strange%');

SELECT f.nome, g.nome
FROM film f
JOIN film_generi fg on f.id = fg.film_id
JOIN generi g on g.id = fg.genere_id;
