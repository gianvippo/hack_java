public class Freelance extends Employer {
    
    public String[] projects;
    public int commission;

    public Freelance(String name, String code, int salary, String[] projects, int commission) {
        super(name, code, salary);
        this.projects = projects;
        this.commission = commission;
        setSalary();
    }

    public void setSalary() {
        int sum = 0;
        for (int i = 0; i < projects.length; i++) {
            sum += this.commission;
        }

        this.salary = this.salary + sum;
    }

    @Override
    public String stampaSalario() {
        return "Il mio stipendio e' " + (this.salary - (this.commission * this.projects.length)) + " con " + this.commission * this.projects.length + " di commissioni";
    }

}
