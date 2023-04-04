import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        // vogliamo creare un programma che, dati dei sensori, prenda la temperatura esterna da ognuno di essi e ritorni la temperatura media
        // creiamo una lista o un array di sensori che inizializziamo

        var sensors = new Sensor[] {
            new Sensor(37, 22),
            new Sensor(28, 22),
            new Sensor(41, 22),
            new Sensor(12, 22),
            new Sensor(25, 22),
        };

        // double sum = 0;
        // for(Sensor sensor : sensors){
        //     sum += sensor.getExternalTemp();
        // }

        System.out.println("Temperatura esterna media e' di " + averageExternalTemp(sensors) + " gradi");



    }

    public static double averageExternalTemp(Sensor[] sensors) {

        double sum = 0;
        for(Sensor sensor : sensors){
                sum += sensor.getExternalTemp();
            }

            return (sum / sensors.length);
    }
}
