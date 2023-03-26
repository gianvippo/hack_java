import java.util.Scanner;

public class EvenArray {
    public static void main(String[] args) {
        // Scrivere un programma che prenda in input un numero, che crei un array di lunghezza pari al numero inserito, che chieda un numero di elementi pari al numero inserito e stampi solo gli elmenti in posizione pari

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la lunghezza dell'array dei numeri: ");

        try {

            int[] numbers = new int[Integer.parseInt(scanner.nextLine())];

            for (int i = 0; i < numbers.length; i++) {
                
                while (true) {
                    
                    System.out.println("Inserisci il numero nella posizione " + i);
                    
                    try {
                        numbers[i] = Integer.parseInt(scanner.nextLine());

                        break;

                    } catch (Exception e) {
                        System.out.println("Non hai inserito un numero valido, riprova");
                    }

                }
            }

            System.out.print("I numeri inseriti in posizioni pari sono");
            for (int i = 0; i < numbers.length; i+=2) {
                System.out.print(" " + numbers[i]);
            }
            System.out.println(".");


        } catch (Exception e) {

            System.out.println("Non hai inserito un numero valido");
        }

        scanner.close();
    }
}
