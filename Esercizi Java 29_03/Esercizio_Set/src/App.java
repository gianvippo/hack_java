import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

        String format = "%-15d%-32s%10s%10d%n";
        String formatTitle = "%-15s%-32s%10s%10s%n";

        Set<Film> western = Set.of(

                new Film("Per un pugno di dollari", "western", 1964),
                new Film("Per qualche dollaro in più", "western", 1965),
                new Film("Il Buono, il Brutto e il Cattivo", "western", 1966)

        );

        if (western.contains(new Film("Per qualche dollaro in più", "western", 1965)))
            System.out.println("E' prensente il film Per qualche dollaro in piu'");

        System.out.println("Al momento sono presenti " + western.size() + " film.");

        LinkedList<Film> drama = new LinkedList<Film>();
        drama.addAll(List.of(
                new Film("Titanic", "drama", 1997),
                new Film("Schindler's List", "drama", 1993),
                new Film("Million Dollar Baby", "drama", 2004)));

        drama.addAll(List.of(
                new Film("Titanic", "drama", 1997),
                new Film("Schindler's List", "drama", 1993),
                new Film("Million Dollar Baby", "drama", 2004)));

        System.out.println("Film prima del Set:");
        System.out.printf(formatTitle, "Codice", "Titolo", "Genere", "Anno");
        for (int i = 0; i < drama.size(); i++) {

            System.out.printf(format, i, drama.get(i).getName(),
                   drama.get(i).getGenre(),drama.get(i).getYear());

        }

        HashSet<Film> film_set = new HashSet<Film>(drama);

        System.out.println("Film dopo il Set:");
        System.out.printf(formatTitle, "Codice", "Titolo", "Genere", "Anno");

        int i = 0;
        for (Film el : film_set) {
            System.out.printf(format, i++, el.getName(),
                    el.getGenre(), el.getYear());
        }

    }

}
