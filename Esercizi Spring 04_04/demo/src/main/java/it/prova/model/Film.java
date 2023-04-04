package it.prova.model;

public class Film {
    
    private String name;
    private Integer year;
    private String genre;
    private FilmSpecs specs;
    private Director director;

    public Film(String name, Integer year, String genre, FilmSpecs specs, Director director) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.specs = specs;
        this.director = director;
        System.out.println("Generato Film");
    }

    public Film() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public FilmSpecs getSpecs() {
        return specs;
    }
    public void setSpecs(FilmSpecs specs) {
        this.specs = specs;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }
     
}
