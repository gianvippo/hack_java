import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Integer[] ints = new Integer[]{8,4,2,6,7,1};

        // in alcuni casi, se vogliamo, tramite la programmazione funzionale, possiamo modificare i dati che manipoliamo
        // non è sicura come cosa

        // Arrays.sort(ints, (a,b) -> a - b);
        // (a,b) -> a - b   --> Lambda, predicato
        Arrays.sort(ints, (a,b) -> Integer.compare(a, b));

        List.of(ints).stream().forEach(el -> System.out.print(el + " "));


        System.out.println();
        String[] names = new String[] {"Pippo", "Pluto", "Mario", "Luigi"};
        
        // ordianiamo in base alla lunghezza
        Arrays.sort(names, (a,b) -> a.length() - b.length());
        // queste lambda implementano Comparator

        System.out.println(String.join(", ", names));


        //-----------------------------------------------

        Persona[] people = new Persona[]{
            new Persona(24, "Pippo", "Disney"),
            new Persona(42, "Pluto", "Disney"),
            new Persona(18, "Paperino", "Disney"),
        };

        //Arrays.sort(people, (a,b) -> a.getAge() - b.getAge());
        Arrays.sort(people, Comparator.comparing(a -> a.getAge())); // qui passiamo il predicato Comparator
        
        System.out.println(Arrays.toString(people));

        Arrays.sort(people, MyComparator.reverse((a,b) -> a.getAge() - b.getAge())); // qui passiamo nostro comparator con il predicato

        System.out.println(Arrays.toString(people));

    }
}
