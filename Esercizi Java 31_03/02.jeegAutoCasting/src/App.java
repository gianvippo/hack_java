public class App {
    public static void main(String[] args) throws Exception {

        // adesso se voglio creare un oggetto e NON preoccuparmi del casting, devo utilizzare la classe JeegFactoryPrototype

        JeegFactoryPrototype factory = new JeegFactoryPrototype();
        LanciaMissili lm = factory.instanceCasting(JeegComponentType.LanciaMissiliDx, LanciaMissili.class);
        Laser laser = factory.instanceCasting(JeegComponentType.LaserSx, Laser.class);
        Legs legs = factory.instanceCasting(JeegComponentType.Legs, Legs.class);

        Jeeg j1 = new Jeeg(lm, laser, legs);
        j1.muovitiInAvanti();
        j1.attacca();
        j1.muovitiIndietro();


    }
}
