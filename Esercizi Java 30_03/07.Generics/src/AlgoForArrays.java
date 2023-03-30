public class AlgoForArrays {
    
    // vogliamo prendere il valore minore all'interno dell'array

    public static <T extends Comparable<T>> T min(T[] values){

        if(values == null || values.length == 0) return null;
        T min = values[0];
        for(T item : values){
            if(item.compareTo(min) < 0) min = item;
        }

        return min;
    }


    public static <T extends Comparable<T>> T max(T[] values){

        if(values == null || values.length == 0) return null;
        T max = values[0];
        for(T item : values){
            if(item.compareTo(max) > 0) max = item;
        }

        return max;
    }
}
