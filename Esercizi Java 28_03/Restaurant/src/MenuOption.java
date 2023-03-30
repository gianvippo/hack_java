public abstract class MenuOption {
    
    private String name;
    private double price;

    public MenuOption(String name, double price) {
        this.name = name;
        this.price = price;
    }

    abstract String stampa();

}
