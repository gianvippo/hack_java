public class Developer extends Employer {
    String[] languages;

    public Developer(String name, String code, int salary, String[] languages) {
        super(name, code, salary);
        this.languages = languages;
    }

    @Override
    public String stampaSalario() {
        return "Il mio stipendio e' " + this.salary;
    }
}
