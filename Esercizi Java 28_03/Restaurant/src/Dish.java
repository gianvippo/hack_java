public class Dish extends MenuOption{

    String name;
    double price;
    Ingredient[] ingredients;

    public Dish(String name, double price, Ingredient[] ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    @Override
    String stampa() {
        return name + " : " + price + " €";
    }
    
}
