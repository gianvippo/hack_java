import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        String format = "%-15d%-32s%10s%10d%n";
        String formatTitle = "%-15s%-32s%10s%10s%n";

        Scanner scanner = new Scanner(System.in);

        ArrayList<Film> western = new ArrayList<Film>();

        western.addAll(List.of(
                new Film("Per un pugno di dollari", "western", 1964),
                new Film("Per qualche dollaro in più", "western", 1965),
                new Film("Il Buono, il Brutto e il Cattivo", "western", 1966)));

        System.out.println("Lista film");
        System.out.printf(formatTitle, "Codice", "Titolo", "Genere", "Anno");
        for (Film el : western) {
            System.out.printf(format, el.getId(), el.getName(),
                    el.getGenre(), el.getYear());
        }

        while (true) {

            int c = 0;
            System.out.println(
                    "\nDigita 1 per modificare un elemento, 2 per aggiungere un film, altro per terminare");

            try {
                c = Integer.parseInt(scanner.nextLine());
                switch (c) {
                    case 1:
                        System.out.println("Ricerca film\n");
                        modifica(western, scanner);
                        break;
                    case 2:
                        System.out.println("Aggiunta film\n");
                        creazione(western, scanner);
                        break;

                    default:
                        System.out.println("Uscita...");
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Non hai inserito un numero, riprova");
            }

        }

    }

    public static void creazione(ArrayList<Film> lista, Scanner scanner) {

        String format = "%-15d%-32s%10s%10d%n";
        String formatTitle = "%-15s%-32s%10s%10s%n";

        System.out.println("Inserisci il Titolo del film:");
        String title = scanner.nextLine();

        System.out.println("Inserisci il genere:");
        String genre = scanner.nextLine();

        int year = 0;

        while (true) {

            System.out.println("\nInserisci l'anno di uscita:");
            int c = 0;

            try {
                year = Integer.parseInt(scanner.nextLine());
                if (year < 1900 || year > 2023)
                    System.out.println("Attenzione, l'anno inserito non è valido");
                else
                    break;
            } catch (Exception e) {
                System.out.println("Non hai inserito un numero valido, riprova");
            }

        }

        Film film = new Film(title, genre, year);

        lista.add(film);

        System.out.println("Ecco fatto! Hai aggiunto correttamente il film. Ecco la nuova lista");
        System.out.println();

        System.out.printf(formatTitle, "Codice", "Titolo", "Genere", "Anno");
        for (Film el : lista) {
            System.out.printf(format, el.getId(), el.getName(),
                    el.getGenre(), el.getYear());
        }

    }

    public static void modifica(ArrayList<Film> lista, Scanner scanner) {

        String format = "%-15d%-32s%10s%10d%n";
        String formatTitle = "%-15s%-32s%10s%10s%n";

        int c = 0;

        while (true) {

            System.out.println("\nInserisci la posizione del film da modificare:");
            c = 0;

            try {
                c = Integer.parseInt(scanner.nextLine());
                System.out.println();
                System.out.println("Stai provando a modificare il film " + lista.get(c).getName());
                break;
            } catch (Exception e) {
                System.out.println("Non hai inserito un numero valido, riprova");
            }

        }

        System.out.println("Inserisci il Titolo del film:");
        String title = scanner.nextLine();

        System.out.println("Inserisci il genere:");
        String genre = scanner.nextLine();

        int year = 0;

        while (true) {

            System.out.println("\nInserisci l'anno di uscita:");

            try {
                year = Integer.parseInt(scanner.nextLine());
                if (year < 1900 || year > 2023)
                    System.out.println("Attenzione, l'anno inserito non è valido");
                else
                    break;
            } catch (Exception e) {
                System.out.println("Non hai inserito un numero valido, riprova");
            }

        }

        Film film = new Film(title, genre, year);

        lista.remove(c);
        lista.add(c, film);

        System.out.println("Perfetto! Hai correttamente modificato il film. Ecco la lista aggiornata:");
        System.out.println();

        System.out.println("Lista film");
        System.out.printf(formatTitle, "Codice", "Titolo", "Genere", "Anno");
        for (Film el : lista) {
            System.out.printf(format, el.getId(), el.getName(),
                    el.getGenre(), el.getYear());
        }

    }
}
