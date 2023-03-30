public class App {
    public static void main(String[] args) throws Exception {

        Arm armDx = new Laser("Destro");
        Arm armSx = new Trivella("Sinistro");
        Legs legs = new Legs();
        
        Jeeg jeeg = new Jeeg(armDx, armSx, legs);

        jeeg.goForward();
        jeeg.goBack();
        jeeg.attacca();

        Jeeg jeeg2 = new Jeeg(new Laser("Destro"), new Laser("Sinistro"), new Propulsori());
        jeeg2.goForward();
        jeeg2.goBack();
        jeeg2.attacca();

        Jeeg jeeg3 = new Jeeg(new Laser("Destro"), new Laser("Sinistro"), new Tank());
        jeeg3.goForward();
        jeeg3.goBack();
        jeeg3.attacca();
        
    }
}
