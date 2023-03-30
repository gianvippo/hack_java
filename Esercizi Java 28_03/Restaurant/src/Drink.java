public class Drink extends MenuOption{

    String name;
    double price;
    
    public Drink(String name, double price) {
        super(name, price);
    }

    @Override
    String stampa() {
        return name + " : " + price + " €";
    }
    
}