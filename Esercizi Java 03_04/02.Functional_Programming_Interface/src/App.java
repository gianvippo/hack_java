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

        System.out.println("Temperatura esterna media presa dai sensori e' di " + averageExternalTemp(sensors, new SensorExternalTempGetter()) + " gradi");


        var thermometer = new Thermometer[] {
           
            new Thermometer(37),
            new Thermometer(28),
            new Thermometer(41),
            new Thermometer(12),
            new Thermometer(25),

        };

        System.out.println("Temperatura esterna media presa dai termometri e' di " + averageExternalTemp(thermometer, new ThermometerExternalTempGetter()) + " gradi");



    }


    // GENERALIZZAZIONE
    // Creo l'interfaccia per ritornare da un oggetto un double, creo la classe che implementa tale metodo e lo utilizzo nel main

    public static double averageExternalTemp(Sensor[] sensors, PropertyGetter pGetter) {

        double sum = 0;
        for(Sensor sensor : sensors){
                // sum += sensor.getExternalTemp();         --> NON PRENDO PIU' IL DATO DALL'OGGETTO SENSOR
                sum += pGetter.getDoubleProperty(sensor);   // MA USO UNA CLASSE CHE IMPLEMENTA IL METODO PER OTTENERE LA PROPRIETA'
            }

            return (sum / sensors.length);
    }


    public static double averageExternalTemp(Thermometer[] therms, PropertyGetter pGetter) {

        double sum = 0;
        for(Thermometer therm : therms){
                // sum += sensor.getExternalTemp();         --> NON PRENDO PIU' IL DATO DALL'OGGETTO THERMOMETER
                sum += pGetter.getDoubleProperty(therm);   // MA USO UNA CLASSE CHE IMPLEMENTA IL METODO PER OTTENERE LA PROPRIETA'
            }

            return (sum / therms.length);
    }


    // !!! NON VA BENE, DOBBIAMO SCRIVERE UNA SOLA FUNZIONE !!!
}
