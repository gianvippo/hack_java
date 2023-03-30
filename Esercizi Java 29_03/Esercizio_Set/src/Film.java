public class Film {
    
    private String name;
    private String genre;
    private int year;

    public Film(String name, String genre, int year) {
        setName(name);
        setGenre(genre);
        setYear(year);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Film){   // se sono della stessa classe
            Film other = (Film) obj;
            return name == other.name && genre == other.genre && year == other.year;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (name + genre + year).hashCode();
    }
    
}
