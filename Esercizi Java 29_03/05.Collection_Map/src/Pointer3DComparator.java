import java.util.Comparator;

// public class Pointer3DComparator implements Comparator {
//     @Override
//     public int compare(Object o1, Object o2) {
//         Pointer3D p1 = (Pointer3D) o1;
//         Pointer3D p2 = (Pointer3D) o2;

//         return ((p1.x + p1.y + p1.z) - (p2.x + p2.y + p2.z));
//     }
// }


public class Pointer3DComparator implements Comparator<Pointer3D> {
    @Override
    public int compare(Pointer3D o1, Pointer3D o2) {
        return ((o1.x + o1.y + o1.z) - (o2.x + o2.y + o2.z));
    }
}
