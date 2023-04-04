public class App {
    public static void main(String[] args) throws Exception {

        var sensors = new Sensor[] {
                new Sensor(37, 22),
                new Sensor(28, 22),
                new Sensor(41, 22),
                new Sensor(12, 22),
                new Sensor(25, 22),
        };

        System.out.println("Temperatura esterna media presa dai sensori e' di "
                + averageExternalTemp(sensors, new SensorExternalTempGetter()) + " gradi");

        var thermometer = new Thermometer[] {

                new Thermometer(37),
                new Thermometer(28),
                new Thermometer(41),
                new Thermometer(12),
                new Thermometer(25),

        };

        System.out.println("Temperatura esterna media presa dai termometri e' di "
                + averageExternalTemp(thermometer, new ThermometerExternalTempGetter()) + " gradi");

        // SENSOR GETTER E THEMOMETER GETTER LAVORANO UGUALI, QUINDI POSSIAMO ASTRARRE
        // ANCORA DI PIU'
        // PASSIAMO ALLA FUNZIONE averageExternalTemp() AL PARAMETRO PROPERTY GETTER UNA
        // LAMBDA ( PREDICATO ) CHE DA UN OGGETTO RITORNI UN DOUBLE, SENZA CREARE
        // APPOSITAMENTE UNA CLASSE

        PropertyGetter sGetter = (Object obj) -> ((Sensor) obj).getExternalTemp(); // --> utilizziamo l'interfaccia per
                                                                                   // creare un oggetto che contiene una
                                                                                   // lambda per ottenere un double da
                                                                                   // un oggetto, CHE RISPETTA
                                                                                   // L'INTERFACCIA

        // Quindi le classi sensor getter e temp getter non servono praticamente più

        PropertyGetter tGetter = (Object obj) -> ((Thermometer) obj).getExternalTemp();

        System.out.println("Temperatura esterna media presa dai sensori con PropertyGetter e' di "
                + averageExternalTemp(sensors, sGetter) + " gradi");

        System.out.println("Temperatura esterna media presa dai termometri con PropertyGetter e' di "
                + averageExternalTemp(thermometer, tGetter) + " gradi");

        System.out.println("Temperatura esterna media presa dai sensori con Lambda e' di "
                + averageExternalTemp(sensors, (Object obj) -> ((Sensor) obj).getExternalTemp()) + " gradi");

        System.out.println("Temperatura esterna media presa dai termometri con Lambda e' di "
                + averageExternalTemp(thermometer, (Object obj) -> ((Thermometer) obj).getExternalTemp()) + " gradi");

    }

    // CREO UNA FUNZIONE GENERICA, CHE ACCETTA UN ARRAY GENERICO ( FARA' IL CASTING
    // AUTOMATICO ) E RITORNA UN DOUBLE
    public static <T> double averageExternalTemp(T[] values, PropertyGetter pGetter) {

        double sum = 0;
        for (T value : values) {
            sum += pGetter.getDoubleProperty(value);
        }

        return (sum / values.length);
    }

}
