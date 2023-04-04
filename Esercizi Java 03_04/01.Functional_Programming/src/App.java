import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        // data una lista i oggetti di classe Person, filtrare le persone in base al
        // genere

        List<Person> people = List.of(

                new Person("Maria", Gender.FEMALE),
                new Person("Marco", Gender.MALE),
                new Person("Paola", Gender.FEMALE),
                new Person("Giovanna", Gender.FEMALE),
                new Person("Roberto", Gender.MALE)

        );

        // IMPERATIVO --> ho indicato al programma tutto quello che doveva fare

        List<Person> females = new ArrayList<>();

        for (Person p : people) {
            if (Gender.FEMALE.equals(p.gender))
                females.add(p);
        }

        for (Person p : females) {
            System.out.println(p.name);
        }

        // DICHIARATIVO
        // Devo creare una lambda

        // person -> Gender.FEMALE.equals(person.gender)    --> questo è un PREDICATO
        // dalla lista genero uno stream ( sequenza di dati che può essere manipolata
        // uno alla volta )
        people.stream()

                // dato che ho creato uno stream indico alla funzione filter in base a cosa deve
                // filtrare il singolo elemento che sto controllando
                .filter(person -> Gender.FEMALE.equals(person.gender)) // in questo momento sto ancora manipolando uno
                                                                       // stream

                // dopo aver filtrato, ho ancora uno stream, non una lista quindi devo
                // trasformare lo stream in lista per poterla poi ciclare e stampare
                // utilizzo il metodo dell'oggeto Collectors.toList() che ritrasforma lo stream
                // in una lista
                .collect(Collectors.toList())
                .forEach(person -> System.out.println(person.name));

                // la lista originale non è stata modificata

        // PER SALVARE

        List<Person> females1 = people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .toList();  // senza usare il Collectors

        for (Person p : females1) {
            System.out.println(p.name);
        }


        List<Integer> ints = List.of(1,5,82,42,4,3,10,15);
        ints.stream().filter(el -> el > 5).limit(5);    // Ripete il ciclo fino a quando trova 5 elementi che soddisfano la condizione



        // INTRUDERS

        List<String> names = Arrays.asList("spring", "java", "oop", "php");
        List<String> intruders = names.stream().filter(name -> name.equals("php")).toList();
        for (String string : intruders) {
            System.out.println(string);
        }



        // vogliamo creare un programma che, dati dei sensori, prenda la temperatura esterna da ognuno di essi e ritorni la temperatura media
        // creiamo una lista o un array di sensori che inizializziamo

        // PROGRAMMAZIONE FUNZIONALE/IMPERATIVA

        var sensors = new Sensor[] {
            new Sensor(37, 22),
            new Sensor(28, 22),
            new Sensor(41, 22),
            new Sensor(12, 22),
            new Sensor(25, 22),
        };

        // double sum = 0;
        // for(Sensor sensor : sensors){
        //     sum += sensor.getExternalTemp();
        // }

        System.out.println("Temperatura esterna media e' di " + averageExternalTemp(sensors) + " gradi");



    }

    public static double averageExternalTemp(Sensor[] sensors) {

        double sum = 0;
        for(Sensor sensor : sensors){
                sum += sensor.getExternalTemp();
            }

            return (sum / sensors.length);
    }
}
