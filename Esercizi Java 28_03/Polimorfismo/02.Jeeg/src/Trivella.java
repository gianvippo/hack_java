public class Trivella extends Arm {

    public Trivella(String side) {
        super(side);
    }
    
    @Override
    public void attacca() {
        System.out.println("Ti buco con la trivella col braccio " + this.side);
    }
}
