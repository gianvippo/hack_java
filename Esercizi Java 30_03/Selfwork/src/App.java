import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // scrivere una classe generica che prenda in input un array e implementi dei
        // metodi che ritornino degli elementi filtrati in base a delle caratteristiche
        // ( numeri pari, numeri dispari, numeri primi )

        Algoritmi<Integer> numbers = new Algoritmi<Integer>(new Integer[] { 3, 15, 85, 24, 65, 72, 31, 150 });

        List<Integer> evenList = numbers.Even();
        System.out.println("Numeri pari: " + evenList);
        List<Integer> oddList = numbers.Odd();
        System.out.println("Numeri dispari: " + oddList);

        // scrivere una classe generica che prenda in input un array e altri due
        // parametri interi che fungeranno da indice superiore e indice inferiore e
        // ritorni un sottoarray nel range indice inferiore indice superiore

        Algoritmi<Integer> numbList = new Algoritmi<Integer>(new Integer[] { 2, 52, 24, 32, 65, 98, 45, 75, 82, 39 },
                20,
                70);

        List<Integer> resultNumb = numbList.minAndMax();
        for (Integer item : resultNumb) {
            System.out.println(item);
        }

        Algoritmi<String> strList = new Algoritmi<String>(new String[] {
                "Andrea",
                "Giuseppe",
                "Franco",
                "Zoe",
                "Pasquale",
                "Gianvito",
                "Antonio",
                "Vanni"
        }, "Antonio", "Vanni");

        List<String> resultStr = strList.minAndMax();
        for (String item : resultStr) {
            System.out.println(item);
        }
    }
}
