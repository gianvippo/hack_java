public class Persona {
    
    private int age;
    private String name;
    private String surname;
    
    public Persona(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Age: " + age + " Name: " + name + " Surname: " + surname;
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    
}
