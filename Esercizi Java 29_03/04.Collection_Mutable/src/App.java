import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {

        HashSet<Pointer3D> points = new HashSet<Pointer3D>(

                Set.of(new Pointer3D(10, 20, 30),
                        new Pointer3D(50, 70, 30),
                        new Pointer3D(800, 500, 422),
                        new Pointer3D(80, 500, 100)));

        for (Pointer3D point : points) {
            point.print();
        }

        Set<Integer> numbers = new TreeSet<Integer>(
                Set.of(5, 2, 8, 122, 25));

        System.out.println(numbers);

        Set<String> strings = new TreeSet<String>(
                Set.of(
                        "pippo", "francesco", "zorro", "andrea"));

        System.out.println(strings);

        // creo un Set che contiene oggetti di classe di Pointer3D
        // a questa set passo come valore principale una classe che implementa
        // l'interfaccia Comparator
        // a questo punto la Set sa come ordinare gli elementi in base alla funzione
        // compare che abbiamo scritto all'interno della classe Pointer3DComparator
        Set<Pointer3D> points1 = new TreeSet<Pointer3D>(new Pointer3DComparator());

        points1.addAll(
                Set.of(
                        new Pointer3D(10, 20, 30),
                        new Pointer3D(50, 70, 30),
                        new Pointer3D(800, 500, 422),
                        new Pointer3D(80, 500, 100)));

        for (Pointer3D point : points1) {
            point.print();
        }
    }

}
