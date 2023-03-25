import java.util.Scanner;

public class SumArray {

    public static void main(String[] args) {

        // Scrivere un programma che prenda in input un numero, che crei un array di
        // lunghezza pari al numero inserito, che chieda un numero di elementi pari al
        // numero inserito e ne faccia la sommatoria

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la lunghezza dell'array dei numeri: ");

        int sum = 0;

        try {

            int length = Integer.parseInt(scanner.nextLine());

            int[] numbers = new int[length];

            for (int i = 0; i < numbers.length; i++) {

                
                while (true) {
                    
                    System.out.println("Inserisci il numero nella posizione " + i);
                    
                    try {
                        numbers[i] = Integer.parseInt(scanner.nextLine());
                        sum += numbers[i];
                        break;

                    } catch (Exception e) {
                        System.out.println("Non hai inserito un numero valido, riprova");
                    }

                }
            }

            System.out.println("\nSomma degli elementi nell'array: " + sum);

        } catch (Exception e) {

            System.out.println("Non hai inserito un numero valido");
        }

        scanner.close();
    }
}
