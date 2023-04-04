import java.util.Comparator;

// a questo comparator INIZIALIZZO T, DEVE RITORNARE UN COMPARATOR, GLI PASSO UN COMPARATOR
public class MyComparator {
    public static <T> Comparator<T> reverse(Comparator<T> comp){
        return (a, b) -> -1 * comp.compare(a, b);
    }
}
