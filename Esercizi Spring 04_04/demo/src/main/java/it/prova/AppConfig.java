package it.prova;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import it.prova.model.Color;
import it.prova.model.Director;
import it.prova.model.Film;
import it.prova.model.FilmSpecs;
import it.prova.model.Ratio;

@Configuration
@ComponentScan("it.prova")
public class AppConfig {
    
    @Bean(name = "strangelove")
    public Film getFilmStrangelove() {
        return new Film("Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb", 1974, "comedy", getFilmSpecsBNONEEIGHTYFIVE(), getDirector());
    }

    @Bean(name = "shining")
    public Film getFilmShining() {
        return new Film("The Shining", 1977, "horror", getFilmSpecsColorONEEIGHTYFIVE(), getDirector());
    }

    @Bean(name = "bn_one_eightyfive")
    public FilmSpecs getFilmSpecsBNONEEIGHTYFIVE() {
        return new FilmSpecs(Color.BN, Ratio.ONE_EIGHTYFIVE);
    }

    @Bean(name = "color_one_eightyfive")
    public FilmSpecs getFilmSpecsColorONEEIGHTYFIVE() {
        return new FilmSpecs(Color.COLOR, Ratio.ONE_EIGHTYFIVE);
    }

    @Bean(name = "kubrick")
    public Director getDirector(){
        return new Director("Stanley", "Kubrick");
    }

}
