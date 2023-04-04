package it.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.repository.FilmRepository;

@Component("filmService")
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository film;

    @Override
    public void play() {
        System.out.println("Play Film " + film.getFilm().getName());
    }

    @Override
    public void buy() {
        System.out.println("Buy Film" + film.getFilm().getName());
    }

    @Override
    public void rent() {
        System.out.println("Rent Film" + film.getFilm().getName());
    }

    public FilmRepository getFilm() {
        return film;
    }

    public void setFilm(FilmRepository film) {
        this.film = film;
    }
    
}
