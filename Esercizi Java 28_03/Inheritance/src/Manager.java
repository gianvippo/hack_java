public class Manager extends Employer{

    // attributi non comuni a Employer
    int bonus;

    public Manager(String name, String code, int salary, int bonus) {

        // tramite la funzione super() richiamo il costruttore della classe genitore
        super(name, code, salary);  // Employer è la super classe di Manager
        this.bonus = bonus;
    }

    @Override
    public String stampaSalario() {
        return "Il mio stipendio e' " + this.salary + this.bonus;
    }
    
}
