abstract public class Engine {
    
    private String name;
    private int cc;
    private int hp;
    
    public Engine(String name, int cc, int hp) {
        this.name = name;
        this.cc = cc;
        this.hp = hp;
    }

    abstract public void on();
    
    abstract public void off();

    abstract public void increaseSpeed();

    abstract public void decreaseSpeed();
    
}
