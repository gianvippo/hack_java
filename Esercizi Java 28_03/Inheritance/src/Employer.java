abstract public class Employer {
    
    String name;
    String code;
    int salary;

    public Employer(String name, String code, int salary) {
        this.name = name;
        this.code = code;
        this.salary = salary;
    }
    
    abstract public String stampaSalario();

}
