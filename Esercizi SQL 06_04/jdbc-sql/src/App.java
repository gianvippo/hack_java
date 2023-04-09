import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/prodotti?user=root&password=root";

    public static void main(String[] args) throws Exception {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM prodotti");

            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getLong("id"));
                System.out.println("nome: " + resultSet.getString("nome"));
                System.out.println("descrizione: " + resultSet.getString("descrizione"));
                System.out.println("prezzo: " + resultSet.getFloat("prezzo"));
                System.out.println();
            }

            System.out.println();

            resultSet = statement.executeQuery("SELECT p.nome, v.attributo, v.valore FROM prodotti p JOIN varianti v ON p.id = v.prodotto_id");
            
            while (resultSet.next()) {
                System.out.println("nome: " + resultSet.getString(1));
                System.out.println("attributo: " + resultSet.getString(2));
                System.out.println("valore: " + resultSet.getString(3));
                System.out.println();
            }

            ResultSet count = statement.executeQuery("SELECT count(*) FROM prodotti p JOIN varianti v ON p.id = v.prodotto_id");
            count.next();
            System.out.println("Le righe sono " + count.getInt(1));

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
