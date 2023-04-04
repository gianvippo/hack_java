public class App {
    public static void main(String[] args) throws Exception {

        // adesso se voglio creare un oggetto e NON preoccuparmi del casting, devo utilizzare la classe JeegFactoryPrototype

        JeegFactorySingleton factory = new JeegFactorySingleton();
        LanciaMissili lm = (LanciaMissili) factory.instance(JeegComponentType.LanciaMissiliDx);
        LanciaMissili lm2 = (LanciaMissili) factory.instance(JeegComponentType.LanciaMissiliDx);
        Laser laser = (Laser) factory.instance(JeegComponentType.LaserSx);
        Legs legs = (Legs) factory.instance(JeegComponentType.Legs);

        System.out.println(lm);
        System.out.println(lm2);

        LanciaMissili lmc = factory.instanceCasting(JeegComponentType.LanciaMissiliDx, LanciaMissili.class);
        LanciaMissili lmc2 = factory.instanceCasting(JeegComponentType.LanciaMissiliSx, LanciaMissili.class);

        System.out.println(lmc);
        System.out.println(lmc2);


        Jeeg j1 = new Jeeg(lm, laser, legs);
        j1.muovitiInAvanti();
        j1.attacca();
        j1.muovitiIndietro();

        Jeeg j2 = new Jeeg(lmc, lmc2, legs);
        j2.muovitiInAvanti();
        j2.attacca();
        j2.muovitiIndietro();


    }
}
