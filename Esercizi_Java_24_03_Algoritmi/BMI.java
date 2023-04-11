import java.util.Scanner;

public class BMI {

    public static void main(String[] args) {
        // Scrivere un programma che prenda in input dall’utente un numero peso e un
        // numero altezza e calcoli il BMI. Formula BMI => peso / (altezza * altezza) *
        // 703

        Scanner scanner = new Scanner(System.in);

        int peso = 0;
        int altezza = 0;

        while (true) {

            System.out.print("Inserisci il tuo peso: ");

            try {
                peso = Integer.parseInt(scanner.nextLine());
                break;

            } catch (Exception e) {
                System.out.println("Non hai inserito un numero valido, riprova");
            }

        }

        while (true) {

            System.out.print("Inserisci la tua altezza in cm: ");

            try {
                altezza = Integer.parseInt(scanner.nextLine());
                break;

            } catch (Exception e) {
                System.out.println("Non hai inserito un numero valido, riprova");
            }

        }

        float alt = altezza;

        alt /= 100;

        float bmi = peso / (float)Math.pow(alt, 2);
        
        System.out.print("Il tuo BMI è: " + bmi);
        
        scanner.close();
    }
}