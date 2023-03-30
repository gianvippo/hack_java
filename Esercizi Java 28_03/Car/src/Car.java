public class Car {
    String name;
    String color;
    int doors;
    Engine engine;

    public Car(String name, String color, int doors, Engine engine) {
        this.name = name;
        this.color = color;
        this.doors = doors;
        this.engine = engine;
    }
    
    public void accendiAuto() {
        this.engine.on();
    }

    public void spegniAuto() {
        this.engine.off();
    }

    public void accelera() {
        this.engine.increaseSpeed();
    }

    public void decelera() {
        this.engine.decreaseSpeed();
    }
}
