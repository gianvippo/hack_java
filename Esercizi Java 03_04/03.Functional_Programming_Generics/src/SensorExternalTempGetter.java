// implementazione dell'interfaccia sull'oggetto Sensor
// quando creerò un'altra classe simile a Sensor, potrò utilizzarla anche sull'altra classe

public class SensorExternalTempGetter implements PropertyGetter{

    @Override
    public double getDoubleProperty(Object obj) {
        Sensor s = (Sensor) obj;                    // castiamo l'oggetto in arrivo
        return s.getExternalTemp();
    }
}
