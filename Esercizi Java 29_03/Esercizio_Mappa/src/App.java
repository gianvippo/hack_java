import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {

        String formatTitle = "%-15s%-32s%10s%10s%n";
        String format = "%-15d%-32s%10s%10d%n";

        Map<Integer, Film> lista_film = new HashMap<Integer, Film>();

        Film pugno = new Film("Per un pugno di dollari", "western", 1964);

        Film dollaro = new Film("Per qualche dollaro in più", "western", 1965);

        Film buono_brutto_cattivo = new Film("Il Buono, il Brutto e il Cattivo", "western", 1966);

        lista_film.putAll(Map.of(
                pugno.getId(), pugno, dollaro.getId(), dollaro, buono_brutto_cattivo.getId(), buono_brutto_cattivo));

        Set<Integer> keySet_lista_film = lista_film.keySet();

        System.out.println("Lista Film:");
        System.out.printf(formatTitle, "Codice", "Titolo", "Genere", "Anno");
        for (int key : keySet_lista_film) {
            System.out.printf(format, lista_film.get(key).getId(), lista_film.get(key).getName(),
                    lista_film.get(key).getGenre(), lista_film.get(key).getYear());
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {

            int c = 0;
            System.out.println(
                    "\nDigita 1 per la ricerca tramite chiave, 2 per aggiungere un film, 3 per modificare un film, 4 per rimuovere un film, altro per terminare");

            try {
                c = Integer.parseInt(scanner.nextLine());
                switch (c) {
                    case 1:
                        System.out.println("Ricerca film\n");
                        ricerca(lista_film, scanner);
                        break;
                    case 2:
                        System.out.println("Aggiunta film\n");
                        creazione(lista_film, scanner);
                        break;

                    case 3:
                        System.out.println("Modifica Film\n");
                        modifica(lista_film, scanner);
                        break;

                    case 4:
                        System.out.println("Eliminazione film");
                        elimina(lista_film, scanner);
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

    public static void ricerca(Map<Integer, Film> lista, Scanner scanner) {

        String format = "%-15d%-32s%10s%10d%n";
        String formatTitle = "%-15s%-32s%10s%10s%n";

        while (true) {

            System.out.println("\nInserisci il codice del film da ricercare:");
            int c = 0;

            try {
                c = Integer.parseInt(scanner.nextLine());
                System.out.println();
                if (lista.containsKey(c))
                    System.out.printf(formatTitle, "Codice", "Titolo", "Genere", "Anno");
                System.out.printf(format, lista.get(c).getId(), lista.get(c).getName(),
                        lista.get(c).getGenre(), lista.get(c).getYear());
                break;
            } catch (Exception e) {
                System.out.println("Non hai inserito un numero valido, riprova");
            }

        }

    }

    public static void elimina(Map<Integer, Film> lista, Scanner scanner) {

        while (true) {

            System.out.println("\nInserisci il codice del film da eliminare:");
            int c = 0;

            try {
                c = Integer.parseInt(scanner.nextLine());
                System.out.println();
                String title = lista.get(c).getName();
                lista.remove(c);
                System.out.println("Il film " + title + " e' stato rimosso con successo!");
                break;
            } catch (Exception e) {
                System.out.println("Non hai inserito un numero valido, riprova");
            }

        }

    }

    public static void modifica(Map<Integer, Film> lista, Scanner scanner) {

        String format = "%-15d%-32s%10s%10d%n";
        String formatTitle = "%-15s%-32s%10s%10s%n";

        int c = 0;

        while (true) {

            System.out.println("\nInserisci il codice del film da modificare:");
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

        lista.replace(c, film);

        System.out.println("Perfetto! Hai correttamente modificato il film. Ecco la lista aggiornata:");
        System.out.println();

        Set<Integer> keySet_lista_film = lista.keySet();

        System.out.printf(formatTitle, "Codice", "Titolo", "Genere", "Anno");
        for (int key : keySet_lista_film) {
            System.out.printf(format, lista.get(key).getId(), lista.get(key).getName(),
                    lista.get(key).getGenre(), lista.get(key).getYear());
        }


    }

    public static void creazione(Map<Integer, Film> lista, Scanner scanner) {

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

        lista.put(film.getId(), film);

        System.out.println("Ecco fatto! Hai aggiunto correttamente il film. Ecco la nuova lista");
        System.out.println();

        Set<Integer> keySet_lista_film = lista.keySet();

        System.out.printf(formatTitle, "Codice", "Titolo", "Genere", "Anno");
        for (int key : keySet_lista_film) {
            System.out.printf(format, lista.get(key).getId(), lista.get(key).getName(),
                    lista.get(key).getGenre(), lista.get(key).getYear());
        }

    }
}
