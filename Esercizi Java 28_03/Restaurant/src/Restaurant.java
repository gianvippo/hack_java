public class Restaurant {

    private String name;
    private Dish[] dishes;
    private Drink[] drinks;
    
    public Restaurant(String name, Dish[] dishes, Drink[] drinks) {
        setName(name);
        setDishes(dishes);
        setDrinks(drinks);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Dish[] getDishes() {
        return dishes;
    }
    public void setDishes(Dish[] dishes) {
        this.dishes = dishes;
    }
    public Drink[] getDrinks() {
        return drinks;
    }
    public void setDrinks(Drink[] drinks) {
        this.drinks = drinks;
    }

    public void stampaMenu() {
        
    }

    
    
}
