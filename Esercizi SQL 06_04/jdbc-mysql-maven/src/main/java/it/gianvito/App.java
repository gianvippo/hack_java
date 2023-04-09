package it.gianvito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.gianvito.model.Prodotto;

public class App {
    // static final String CONNECTION_STRING =
    // "jdbc:mysql://localhost:3306/prodotti?user=root&password=root";

    // public static void main(String[] args) throws Exception {

    // try {
    // Class.forName("com.mysql.cj.jdbc.Driver");
    // Connection connection = DriverManager.getConnection(CONNECTION_STRING);
    // Statement statement = connection.createStatement();

    // ResultSet resultSet = statement.executeQuery("SELECT * FROM prodotti");

    // while (resultSet.next()) {
    // System.out.println("id: " + resultSet.getLong("id"));
    // System.out.println("nome: " + resultSet.getString("nome"));
    // System.out.println("descrizione: " + resultSet.getString("descrizione"));
    // System.out.println("prezzo: " + resultSet.getFloat("prezzo"));
    // System.out.println();
    // }

    // System.out.println();

    // resultSet = statement.executeQuery("SELECT p.nome, v.attributo, v.valore FROM
    // prodotti p JOIN varianti v ON p.id = v.prodotto_id");

    // while (resultSet.next()) {
    // System.out.println("nome: " + resultSet.getString(1));
    // System.out.println("attributo: " + resultSet.getString(2));
    // System.out.println("valore: " + resultSet.getString(3));
    // System.out.println();
    // }

    // ResultSet count = statement.executeQuery("SELECT count(*) FROM prodotti p
    // JOIN varianti v ON p.id = v.prodotto_id");
    // count.next();
    // System.out.println("Le righe sono " + count.getInt(1));

    // } catch (SQLException e) {
    // System.out.println(e);
    // }

    // }

    public static void main(String[] args) throws Exception {
        // inizializziamo il context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Inizializziamo il Dao
        ProdottoDAO dao = context.getBean(ProdottoDAO.class);

        System.out.println("I prodotti nel DB sono " + dao.count());

        // Otteniamo dal DB tramite id un record
        Prodotto p = dao.getOne(1);

        // Stampiamo il record
        System.out.println("id: " + p.getId() + " nome: " + p.getNome() + " descrizione: " + p.getDescrizione()
                + " prezzo: " + p.getPrezzo());
        System.out.println();

        // Otteniamo una lista di record con .getData()
        List<Prodotto> pList = dao.getData();
        for (Prodotto prodotto : pList) {
            System.out.println("id: " + prodotto.getId() + " nome: " + prodotto.getNome() + " descrizione: "
                    + prodotto.getDescrizione() + " prezzo: " + prodotto.getPrezzo());
        }

        // Creiamo un nuovo prodotto
        Prodotto scarpe = new Prodotto();
        scarpe.setNome("Puma ginnastica");
        scarpe.setPrezzo(25f);
        scarpe.setDescrizione("Puma bianche e nere");

        // Inseriamo il prodotto nel DB
        // dao.insert(scarpe);

        System.out.println();
        System.out.println("I prodotti nel DB sono " + dao.count());

        p = dao.getOne(4);

        System.out.println("id: " + p.getId() + " nome: " + p.getNome() + " descrizione: " + p.getDescrizione()
                + " prezzo: " + p.getPrezzo());
        System.out.println();

        // Eliminiamo un prodotto sempre tramite id
        // dao.delete(8);

        System.out.println("I prodotti nel DB sono " + dao.count());

        // UPDATE
        dao.update(3, scarpe);


        ((ConfigurableApplicationContext) context).close();
    }

}
