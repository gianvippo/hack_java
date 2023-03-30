public class App {
    public static void main(String[] args) throws Exception {

        Arm armDx = new Laser("Destro");
        Arm armSx = new Trivella("Sinistro");
        Legs legs = new Legs();
        
        Jeeg jeeg = new Jeeg(armDx, armSx, legs);

        jeeg.goForward();
        jeeg.goBack();
        jeeg.attacca();
    }
}
