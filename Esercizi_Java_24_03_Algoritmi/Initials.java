import java.util.Scanner;

public class Initials {
    
    public static void main(String[] args) {
        
        // Scrivere un programma che chieda all'utente una stringa e ritorni le iniziali di ogni parola con il . Esempio: "Ciao sono una stringa" => c.s.u.s

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una stringa per ottenere le iniziali: ");

        String string = scanner.nextLine();
        string = string.toLowerCase();

        System.out.print("Le iniziali sono: ");

        if (string.charAt(0) != ' ') System.out.print(string.charAt(0) + ".");

        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i-1) == ' ') System.out.print(string.charAt(i) + ".");
        }

        scanner.close();
    }
}
