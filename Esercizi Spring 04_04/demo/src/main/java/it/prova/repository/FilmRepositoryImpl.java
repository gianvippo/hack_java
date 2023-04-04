package it.prova.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.prova.model.Film;

@Component("filmRepository")
public class FilmRepositoryImpl implements FilmRepository{

    @Autowired
    @Qualifier("shining")
    private Film film;

    @Override
    public Film getFilm() {
        return this.film;
    }

    @Override
    public void setFilm(Film film) {
        this.film = film;
    }
    
}
