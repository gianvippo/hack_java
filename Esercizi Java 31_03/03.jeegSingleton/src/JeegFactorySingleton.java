import java.util.HashMap;
import java.util.Map;

public class JeegFactorySingleton {

    // devo controllare, ad ogni richiesta di un nuovo componente, se questo è già
    // presente in memoria

    private Map<JeegComponentType, Object> registry = new HashMap<JeegComponentType, Object>();

    public Object instance(JeegComponentType jComponentType) {

        switch (jComponentType) {
            case Legs:
                // prima di restituire il componente controllo se esiste già nel mio registro
                if (!registry.containsKey(jComponentType))
                    registry.put(jComponentType, new Legs());
                break;

            case LanciaMissiliDx:
                if (!registry.containsKey(jComponentType))
                    registry.put(jComponentType, new LanciaMissili("Destro"));
                break;

            case LanciaMissiliSx:
                if (!registry.containsKey(jComponentType))
                    registry.put(jComponentType, new LanciaMissili("Sinistro"));
                break;

            case Tank:
                if (!registry.containsKey(jComponentType))
                    registry.put(jComponentType, new Tank());
                break;

            case LaserDx:
                if (!registry.containsKey(jComponentType))
                    registry.put(jComponentType, new Laser("Destro"));
                break;

            case LaserSx:
                if (!registry.containsKey(jComponentType))
                    registry.put(jComponentType, new Laser("Sinistro"));
                break;
        }

        return registry.get(jComponentType);

    }

    @SuppressWarnings("unchecked")
    public <T> T instanceCasting(JeegComponentType jComponentType, Class<T> classType) {
        switch (jComponentType) {
            case Legs:
                // prima di restituire il componente controllo se esiste già nel mio registro
                if (!registry.containsKey(jComponentType))
                    registry.put(jComponentType, new Legs());
                break;

            case LanciaMissiliDx:
                if (!registry.containsKey(jComponentType))
                    registry.put(jComponentType, new LanciaMissili("Destro"));
                break;

            case LanciaMissiliSx:
                if (!registry.containsKey(jComponentType))
                    registry.put(jComponentType, new LanciaMissili("Sinistro"));
                break;

            case Tank:
                if (!registry.containsKey(jComponentType))
                    registry.put(jComponentType, new Tank());
                break;

            case LaserDx:
                if (!registry.containsKey(jComponentType))
                    registry.put(jComponentType, new Laser("Destro"));
                break;

            case LaserSx:
                if (!registry.containsKey(jComponentType))
                    registry.put(jComponentType, new Laser("Sinistro"));
                break;
        }

        return (T) registry.get(jComponentType);
    }

}