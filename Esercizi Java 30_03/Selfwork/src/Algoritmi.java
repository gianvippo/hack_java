import java.util.ArrayList;
import java.util.List;

public class Algoritmi<T extends Comparable<T>> {
    
    T[] array;
    T min;
    T max;

    public Algoritmi(T[] array, T min, T max) {
        this.array = array;
        this.min = min;
        this.max = max;
    }

    public Algoritmi(T[] parametro) {
        this.array = parametro;
    }
    
    public List<T> Even()
    {
        if(this.array == null || array.length == 0) return null;
        List<T> result = new ArrayList<T>();
        for(T item : array)
        {
            if((Integer)item % 2 == 0) result.add(item); //cast
        }
        
        return result;
    }
    
    public List<T> Odd()
    {
        if(this.array == null || array.length == 0) return null;
        List<T> result = new ArrayList<T>();
        for(T item : array)
        {
            if((Integer)item % 2 != 0) result.add(item); //cast
        }
        
        return result;
    }

    public List<T> minAndMax(){
        
        List<T> result = new ArrayList<T>();
        for(T item : array)
        {
            if(item.compareTo(min) > 0 && item.compareTo(max) < 0) result.add(item);
        }
        return result;
    }

}
