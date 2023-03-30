import java.lang.reflect.Field;

public class App {
    public static void main(String[] args) throws Exception {
        Developer dipendente1 = new Developer("Franco", "BA3350", 1500, new String[] {"C", "C#", "Java"});
        Manager manager1 = new Manager("Pippo", "BA0012", 3000, 500);
    
        System.out.println(dipendente1);
        System.out.println(manager1);       // visualizziamo il riferimento
    
        Field[] fields = manager1.getClass().getDeclaredFields();
        for(Field field: fields) {
           System.out.println(field.get(manager1));
        }

        // CON .getDeclaredFields(); PRENDIAMO SOLO I CAMPI DICHIARATI NELLA CLASSE FIGLIA 
    
        System.out.println(dipendente1.stampaSalario());

        Freelance freelance1 = new Freelance("Ciccio", "4585", 500, new String[] {"ESA", "Nike", "Tesla"}, 400);
    
        System.out.println(freelance1.stampaSalario());
    }
}
