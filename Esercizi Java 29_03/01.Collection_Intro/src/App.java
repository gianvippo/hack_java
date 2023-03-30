import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        // List people = new List(); -> non lo posso utilizzare perchè List è un'interfaccia
    
        List<Persona> people = new ArrayList<Persona>();

        // 1. add

        people.add(new Persona("Gianvito", "Palmisano", 25));
        people.add(new Persona("Franco", "Neri", 60));
        people.add(new Persona("Ciccio", "Franco", 30));

        for (int i = 0; i < people.size(); i++) {
            
            System.out.println(people.get(i).getName());

        }

        people.set(1, new Persona("Lino", "Banfi", 80));
    
        for(Persona p : people) {
            System.out.println(p.getName());
        }

        
    }
}
