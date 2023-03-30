public class GasolineEngine extends Engine {

    String injection;

    public GasolineEngine(String name, int cc, int hp, String injection) {
        super(name, cc, hp);
        this.injection = injection;
    }

    @Override
    public void on() {
        System.out.println("Avvio motore benzina con sistema a " + this.injection);
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
