import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        // List people = new List(); -> non lo posso utilizzare perchè List è un'interfaccia
    
        LinkedList<Persona> people = new LinkedList<Persona>(

        List.of(
            new Persona("Gianvito", "Palmisano", 25),
            new Persona("Antonio", "Pansini", 24),
            new Persona("Giuseppe", "Speranza", 27)
        )

        );

        for(Persona p : people) {

            System.out.println(p.getName());
        }

        System.out.println(people.get(2).getSurname());

        people.addFirst(new Persona("Giovanni", "Ruffolo", 50));
        
        System.out.println(people.get(0).getName());
    }
}
