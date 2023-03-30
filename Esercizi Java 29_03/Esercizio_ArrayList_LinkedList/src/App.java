import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Film> western = new ArrayList<Film>();

        western.addAll(List.of(
            new Film("Per un pugno di dollari", "western", 1964),
            new Film("Per qualche dollaro in più", "western", 1965),
            new Film("Il Buono, il Brutto e il Cattivo", "western", 1966)
        ));

        Film texano = new Film("Il texano dagli occhi di ghiaccio", "western", 1976);
        western.add(texano);

        ricerca(texano, western);

        System.out.println("Al momento sono presenti " + western.size() + " film.");

        western.remove(2);

        ricerca(new Film("Il Buono, il Brutto e il Cattivo", "western", 1966), western);

        System.out.println("Film presenti:");

        for(Film film : western){
            System.out.println(film.getName());
        }


        LinkedList<Film> drama = new LinkedList<Film>();
        drama.addAll(List.of(
            new Film("Titanic", "drama", 1997),
            new Film("Schindler's List", "drama", 1993)
        ));

        drama.addFirst(new Film("C'era una volta in America", "drama", 1984));
        drama.removeLast();

        System.out.println("Film presenti:");

        for(Film film : drama){
            System.out.println(film.getName());
        }


    }

    public static void ricerca(Film film, ArrayList<Film> collezione) {
        if (collezione.contains(film))
            System.out.println("E' presente il film " + film.getName());
        else
            System.out.println("Non è presente il film " + film.getName());
    }
}
