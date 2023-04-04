package it.prova.model;

public class Director {
    private String name;
    private String surname;
    
    public Director(String name, String surname) {
        this.name = name;
        this.surname = surname;
        System.out.println("Generato Director");
    }
    public Director() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
}
