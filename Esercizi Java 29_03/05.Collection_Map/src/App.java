import java.util.HashMap;
import java.util.Map;
public class App {
    public static void main(String[] args) throws Exception {

        Map<String, Persona> rubrica = new HashMap<String, Persona>();

        Persona gianvito = new Persona("Gianvito", "Palmisano", "PLMGVT97");
        rubrica.put(gianvito.getCf(), gianvito);

        Persona andrea = new Persona("Andrea", "Mininni", "MNNNDR94");
        rubrica.put(andrea.getCf(), andrea);

        // Set<String> keySet = rubrica.keySet();

        for(String key : rubrica.keySet()){
            System.out.println(rubrica.get(key).getCf());
        }

        rubrica.remove(andrea.getCf());

        for(String key : rubrica.keySet()){
            System.out.println(rubrica.get(key).getCf());
        }

        // dato che non ha senso utilizzare lo stesso oggetto come chiave di un elemento della map creiamo una chiave personalizzata
        Map<RubricaKey, Persona> rubricaKey = new HashMap<RubricaKey, Persona>();
        Persona gianvito2 = new Persona("Gianvito", "Palmisano", "PLMGVT97");

        // da gianvito e gianvito2 genero due chiavi
        RubricaKey key1 = new RubricaKey(gianvito.getCf(), 10);
        rubricaKey.put(key1, gianvito);

        RubricaKey key2 = new RubricaKey(gianvito2.getCf(), 10);
        rubricaKey.put(key2, gianvito2);

        // agli occhi del linguaggio anche se le chiavi hanno valori uguali rimangono due reference diverse quindi aggiunge comunque i due elementi alla map
        // bisogna fare l'override di hashcode e equal
        for(RubricaKey key : rubricaKey.keySet()){
            System.out.println(rubricaKey.get(key).getName());
        }

    }

}
