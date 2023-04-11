import java.util.Scanner;

public class Reverse {
    
    public static void main(String[] args) {
        
        // scrivere un programma che prenda in input un numero e ritorni l’inverso del numero inserito es. 123 => 321

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");

        
        try {

            int number = Integer.parseInt(scanner.nextLine());
            System.out.println("Inserito numero: " + number);

            int reverse = 0;

            while (number != 0) {
                int digit = number % 10;
                reverse = (reverse * 10) + digit;
                number /= 10;
            }

            System.out.println("\nNumero invertito: " + reverse);

        } catch (Exception e) {

            System.out.println("Non hai inserito un numero");
        }


        scanner.close();
    }
}
