import java.util.Comparator;

public class RubricaKeyComparator implements Comparator<RubricaKey>{
    
    @Override
    public int compare(RubricaKey o1, RubricaKey o2) {
        return o1.progressive - o2.progressive;
    }
}
