import java.util.Scanner;

public class Palindroma {

    public static void main(String[] args) {
        // Scrivere un programma che controlli se una stringa è palindroma

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una stringa per verificare se e' palindroma: ");

        String string = scanner.nextLine();

        if (palindroma(string.replaceAll("\\s", ""))) System.out.println("Palindroma");
        else System.out.println("Non palindroma");

        scanner.close();

    }

    public static boolean palindroma(String string) {

        for (int i = 0; i < (string.length() / 2); i++) {

            if (string.charAt(i) != string.charAt(string.length() - i - 1)) return false;

        }

        return true;
    }
}
