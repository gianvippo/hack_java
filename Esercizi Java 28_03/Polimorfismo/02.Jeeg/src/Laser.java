public class Laser extends Arm {

    public Laser(String side) {
        super(side);
    }
    
    @Override
    public void attacca() {
        System.out.println("Ti attacco con il laser nel braccio " + this.side);
    }

}
