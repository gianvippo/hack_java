public class DieselEngine extends Engine {
    
    boolean fap;

    public DieselEngine(String name, int cc, int hp, boolean fap) {
        super(name, cc, hp);
        this.fap = fap;
    }

    @Override
    public void on() {
        System.out.println("Avvio motore diesel");
        if (this.fap) System.out.println("FAP presente.");
        else System.out.println("FAP non presente");
    }
    
    @Override
    public void off() {
        System.out.println("Spegnimento motore");
    }

    @Override
    public void increaseSpeed() {
        System.out.println("Accelero");
    }

    @Override
    public void decreaseSpeed() {
        System.out.println("Decelero");
    }

    
}
