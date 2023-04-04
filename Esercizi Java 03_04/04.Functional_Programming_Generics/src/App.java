public class App {
    public static void main(String[] args) throws Exception {

        var sensors = new Sensor[] {
                new Sensor(37, 22),
                new Sensor(28, 22),
                new Sensor(41, 22),
                new Sensor(12, 22),
                new Sensor(25, 22),
        };

        var thermometer = new Thermometer[] {

                new Thermometer(37),
                new Thermometer(28),
                new Thermometer(41),
                new Thermometer(12),
                new Thermometer(25),

        };

        // GenericPropertyGetter pGetter = (Object obj) -> new Object(); // --> DA ERRORE, SI ASPETTA UN DOUBLE DI RITORNO

        System.out.println("Temperatura esterna media presa dai sensori con Lambda e' di "
                + averageExternalTemp(sensors, (Object obj) -> ((Sensor) obj).getExternalTemp()) + " gradi");

        System.out.println("Temperatura esterna media presa dai termometri con Lambda e' di "
                + averageExternalTemp(thermometer, (Object obj) -> ((Thermometer) obj).getExternalTemp()) + " gradi");

    }

    // nel parametro possiamo passare direttamente un'interfaccia
    public static <T> double averageExternalTemp(T[] values, GenericPropertyGetter<T> pGetter) {

        double sum = 0;
        for (T value : values) {
                // getPropery() è (Object obj) -> ((Sensor) obj).getExternalTemp()
            sum += pGetter.getProperty(value);
        }

        return (sum / values.length);
    } // funzione di ordine superiore, funzione che possono prendere in input altre funzioni

}
