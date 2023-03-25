import java.util.Scanner;

public class Summation {
    
    public static void main(String[] args) {
        
        // Scrivere un programma che prenda in input un numero e ritorni la sommatoria delle cifre che lo compongono es: 123 => 6

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");

        
        try {

            int sum = 0;

            int number = Integer.parseInt(scanner.nextLine());
            System.out.println("Inserito numero: " + number);

            while (number != 0) {
                int digit = number % 10;
                sum += digit;
                number /= 10;
            }

            System.out.println("\nSommatoria: " + sum);

        } catch (Exception e) {

            System.out.println("Non hai inserito un numero");
        }


        scanner.close();

    }
}
