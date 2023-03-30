abstract public class Arm {
    protected String side;

    public Arm(String side) {
        this.side = side;
    }

    // public void attacca() {
    //     System.out.println("Ti attacco con il braccio " + this.side);
    // }

    abstract public void attacca();
}
