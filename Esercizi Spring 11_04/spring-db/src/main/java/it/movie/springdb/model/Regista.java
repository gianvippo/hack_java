package it.movie.springdb.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "registi")
public class Regista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nome", length = 20)
    private String nome;

    @Column(name = "cognome", length = 20)
    private String cognome;

    @Column(name = "anno_di_nascita")
    private Integer anno_di_nascita;

    @OneToMany(mappedBy = "regista")
    private List<Film> listFilm = new ArrayList<Film>();

    public Regista() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getAnno_di_nascita() {
        return anno_di_nascita;
    }

    public void setAnno_di_nascita(Integer anno_di_nascita) {
        this.anno_di_nascita = anno_di_nascita;
    }

    public List<Film> getListFilm() {
        return listFilm;
    }

    public void setListFilm(List<Film> listFilm) {
        this.listFilm = listFilm;
    }
    
}
