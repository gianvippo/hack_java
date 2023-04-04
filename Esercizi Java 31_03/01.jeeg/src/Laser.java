public class Laser extends Arm{

    public Laser(String sideLabel) {
        super(sideLabel);
    }

    @Override
    public void attacca() {
        System.out.println("Brucio il nemico con il laser " + this.sideLabel);
    }
    

}
