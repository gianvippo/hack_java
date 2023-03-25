import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {

        // Scrivere un programma che prenda in input un numero e ritorni se il numero è pari o dispari

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");

        try {

            if(Integer.parseInt(scanner.nextLine()) % 2 == 0) System.out.println("Il numero inserito e' pari.");
            else System.out.println("Il numero inserito e' dispari.");

        } catch (Exception e) {

            System.out.println("Non hai inserito un numero valido");
        }

        scanner.close();
    }
}
