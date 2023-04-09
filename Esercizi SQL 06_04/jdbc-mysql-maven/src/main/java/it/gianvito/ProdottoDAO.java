package it.gianvito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import it.gianvito.model.Prodotto;

@Component
public class ProdottoDAO implements Dao<Prodotto> {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM prodotti", Integer.class);
    }

    public List<Prodotto> getGreaterThanPrezzo(Float prezzoMin) {
        return jdbcTemplate.query("SELECT * FROM prodotti WHERE prezzo > ?", new BeanPropertyRowMapper<Prodotto>(Prodotto.class), prezzoMin);
    }

    @Override
    public List<Prodotto> getData() {
        return jdbcTemplate.query("SELECT * FROM prodotti", new BeanPropertyRowMapper<Prodotto>(Prodotto.class));
    }

    @Override
    public Prodotto getOne(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM prodotti WHERE id = ?", new BeanPropertyRowMapper<Prodotto>(Prodotto.class), id);
    }

    @Override
    public boolean insert(Prodotto model) {
        int result = jdbcTemplate.update("INSERT INTO prodotti (nome, descrizione, prezzo) value (?, ?, ?)", model.getNome(), model.getDescrizione(), model.getPrezzo());
        return result > 0;
    }

    @Override
    public boolean update(Integer id, Prodotto model) {
        int result = jdbcTemplate.update("UPDATE prodotti SET nome = ?, descrizione = ?, prezzo = ? WHERE id = ?", model.getNome(), model.getDescrizione(), model.getPrezzo(), id);
        return result > 0;
    }

    @Override
    public boolean delete(Integer id) {
        int result = jdbcTemplate.update("DELETE FROM prodotti WHERE id = ?", id);
        return result > 0;
    }

    
}
