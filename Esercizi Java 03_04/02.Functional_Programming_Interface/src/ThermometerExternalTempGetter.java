public class ThermometerExternalTempGetter implements PropertyGetter{
    @Override
    public double getDoubleProperty(Object obj) {
        Thermometer s = (Thermometer) obj;                    // castiamo l'oggetto in arrivo
        return s.getExternalTemp();
    }
}
