import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        Ingredient hamburgher = new Ingredient("Hamburgher");
        Ingredient ketchup = new Ingredient("Ketchup");
        Ingredient maionese = new Ingredient("Maionese");
        Ingredient patatine = new Ingredient("Patatine");
        Ingredient bacon = new Ingredient("Bacon");

        Dish panino1 = new Dish("Panino 1", 11, new Ingredient[]{hamburgher, ketchup});
        Dish panino2 = new Dish("Panino 2", 12, new Ingredient[]{hamburgher, ketchup, patatine});
        Dish panino3 = new Dish("Panino 3", 15, new Ingredient[]{hamburgher, ketchup, patatine, bacon, maionese});

        Drink drink1 = new Drink("Coca Cola", 2);
        Drink drink2 = new Drink("Fanta", 2);
        Drink drink3 = new Drink("Pepsi", 3);

        Dish[] piatti = new Dish[]{panino1, panino2, panino3};
        Drink[] drinks = new Drink[]{drink1, drink2, drink3};
        
        Restaurant ManVsFood = new Restaurant("Man Vs Food", piatti, drinks);

        System.out.println("Benvenuti da Man Vs Food! Ecco il nostro menu:");
        for(Dish dish : ManVsFood.getDishes()){
            System.out.println(dish.stampa());
        }
        System.out.println("Ecco le nostre bevande:");
        for(Drink drink : ManVsFood.getDrinks()){
            System.out.println(drink.stampa());
        }


    }
}
