public class App {
    public static void main(String[] args) throws Exception {
        
        Engine engine = new GasolineEngine("FIRE", 1200, 69, "carburatore");
        Car car = new Car("Panda", "Bianco", 4, engine);

        car.accendiAuto();
        car.accelera();
        car.decelera();
        car.spegniAuto();
    }
}
