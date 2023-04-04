package it.prova;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.prova.model.Film;
import it.prova.model.FilmSpecs;
import it.prova.service.FilmService;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Film drStrangelove = context.getBean("strangelove", Film.class);
        FilmSpecs specs = context.getBean("bn_one_eightyfive", FilmSpecs.class);
        System.out.println(drStrangelove);
        System.out.println(drStrangelove.getSpecs());
        System.out.println(specs);

        FilmService filmService = context.getBean("filmService", FilmService.class);

        filmService.play();
        
        ((ConfigurableApplicationContext)context).close();

    }
}
