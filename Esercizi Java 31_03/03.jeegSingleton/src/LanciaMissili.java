public class LanciaMissili extends Arm {

    public LanciaMissili(String sideLabel) {
        super(sideLabel);
    }

    @Override
    public void attacca() {
        System.out.println("Sparo il missile " + this.sideLabel);
    }
    
}
