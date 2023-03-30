import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        
        Set<Pointer3D> points = Set.of(

        new Pointer3D(10, 20, 30),
        new Pointer3D(50, 70, 30),
        new Pointer3D(800, 500, 422),
        new Pointer3D(80, 500, 100)


        );

        for(Pointer3D point : points) {
            point.print();
        }
        
    }
}
