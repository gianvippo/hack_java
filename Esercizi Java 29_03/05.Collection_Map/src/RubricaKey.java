public class RubricaKey {
    
    String cf;
    int progressive;

    public RubricaKey(String cf, int progressive) {
        this.cf = cf;
        this.progressive = progressive;
    }

    @Override
    public int hashCode() {
        final int prime = 31; // -> costante
        int result = 1;
        result = prime * result + ((cf == null ? 0 : cf.hashCode()));
        result = prime * result + progressive;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // return as soon as possible
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        // controlli se le classi coincidono
        RubricaKey other = (RubricaKey) obj;

        // se il cf dell'oggetto in cui sono non esiste
        if(cf == null){
            // controlla se l'altro oggetto ha un cf
            if(other.cf != null) return false;
        } else if(!cf.equals(other.cf)) return false;

        if(progressive != other.progressive) return false;

        return true;

    }

}
