public class JeegFactory {

    // ritornerà gli oggetti con cui creerò Jeeg
    public Object instance(JeegComponentType componentName) {

        Object component = null;

        switch (componentName) {
            case Legs:
                component = new Legs();
                break;

            case Tank:
                component = new Tank();
                break;

            case LanciaMissiliDx:
                component = new LanciaMissili("Destro");
                break;

            case LanciaMissiliSx:
                component = new LanciaMissili("Sinistro");
                break;

            case LaserSx:
                component = new Laser("Sinistro");
                break;

            case LaserDx:
                component = new Laser("Destro");
                break;
        }

        return component;
    }
}
