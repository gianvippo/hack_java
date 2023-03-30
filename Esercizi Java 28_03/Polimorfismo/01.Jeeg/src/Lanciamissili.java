public class Lanciamissili extends Arm {

    public Lanciamissili(String side) {
        super(side);
    }
    
    @Override
    public void attacca() {
        System.out.println("Lancio un missile con il braccio " + this.side);
    }

}
