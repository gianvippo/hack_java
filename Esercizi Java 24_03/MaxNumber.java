import java.util.Scanner;

public class MaxNumber {

    public static void main(String[] args) {
        // Scrivere un programma che prenda in input un numero, che crei un array di lunghezza pari al numero inserito, che chieda un numero di elementi pari al numero inserito e ritorni il valore massimo inserito

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la lunghezza dell'array dei numeri: ");

        int[] value = new int[2];

        try {

            int length = Integer.parseInt(scanner.nextLine());

            int[] numbers = new int[length];

            for (int i = 0; i < numbers.length; i++) {
                
                while (true) {
                    
                    System.out.println("Inserisci il numero nella posizione " + i);
                    
                    try {
                        numbers[i] = Integer.parseInt(scanner.nextLine());
                        if(numbers[i] > value[0]) {
                            value[0] = numbers[i];
                            value[1] = i;
                        }
                        break;

                    } catch (Exception e) {
                        System.out.println("Non hai inserito un numero valido, riprova");
                    }

                }
            }

            System.out.println("\nL'elemento piu' grande e' " + value[0] + " in posizione " + value[1]);

        } catch (Exception e) {

            System.out.println("Non hai inserito un numero valido");
        }

        scanner.close();
    }
}
