package it.prova.model;

public class FilmSpecs {
    
    private Color color;
    private Ratio ratio;
    
    public FilmSpecs() {
    }

    public FilmSpecs(Color color, Ratio ratio) {
        this.color = color;
        this.ratio = ratio;
        System.out.println("Generato Specs");
    }
    
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Ratio getRatio() {
        return ratio;
    }
    public void setRatio(Ratio ratio) {
        this.ratio = ratio;
    }
    
}
