public class App {
    public static void main(String[] args) throws Exception {

        // tutti i componenti di jeeg vengono creati nella classe App
        // LanciaMissili lm = new LanciaMissili("Destro");
        // Laser laser = new Laser("Sinistro");
        // Legs legs = new Legs();


        // Possiamo usare Factory
        // è una classe che, in base a dei parametri, ritorna un oggetto

        JeegFactory factory = new JeegFactory();

        // ritorna un oggetto generico, se non casto da errore poichè l'object generico che arriva non possiede instance()
        LanciaMissili lm = (LanciaMissili) factory.instance(JeegComponentType.LanciaMissiliDx);
        Laser laser = (Laser) factory.instance(JeegComponentType.LaserSx);
        Legs legs = (Legs) factory.instance(JeegComponentType.Legs);

        Jeeg j1 = new Jeeg(lm, laser, legs);
        j1.muovitiInAvanti();
        j1.attacca();
        j1.muovitiIndietro();


    }
}
