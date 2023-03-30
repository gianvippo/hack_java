import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        
        // TreeMap
        // vogliamo creare una mappa che ordini gli elementi tramite le chiavi rubricaKey in base al progressivo con cui costruiamo una rubricaKey

        // SE PASSO NEL COSTRUTTORE DELLA MAPPA UNA CLASSE CHE IMPLEMENTA COMPARATOR (INTERFACCIA) LA MAP CAPISCE CHE NON E' UN ELEMENTO DA AGGIUNGERE COEM VALORE MA UN METODO CHE CONSENTIRA' DI COMPARARE GLI ELEMENTI CHE ANDRO' A INSERIRE NELLA MAPPA
        TreeMap<RubricaKey, Persona> rubrica = new TreeMap<RubricaKey, Persona>(new RubricaKeyComparator());

        Persona gianvito = new Persona("Gianvito", "Palmisano", "PLMGVT97");
        RubricaKey key1 = new RubricaKey(gianvito.getCf(), 8);

        Persona antonio = new Persona("Antonio", "Pansini", "PNSNT98");
        RubricaKey key2 = new RubricaKey(antonio.getCf(), 7);

        rubrica.put(key2, antonio);
        rubrica.put(key1, gianvito);

        for(RubricaKey key : rubrica.keySet()){
            System.out.println(rubrica.get(key).getName());
        }


    }
}
