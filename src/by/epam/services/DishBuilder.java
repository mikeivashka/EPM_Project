package by.epam.services;

import by.epam.entity.Dish;
import by.epam.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DishBuilder {
    public Dish DishBuilder() {
        return new Dish();
    }

    public Dish DishBuilder(String title, Integer caloriesCapacity, HashMap<Product, Integer> ingredients, String link){
        return getDish(title, caloriesCapacity, ingredients, link);
    }

    public Dish getDish(String title, Integer caloriesCapacity, HashMap<Product, Integer> ingredients, String link){
        Dish dish = new Dish();
        dish.setTitle(title);
        dish.setRecepyLink(link);
        dish.setIngredients(ingredients);
        dish.setCaloriesCapacity(caloriesCapacity);
        return dish;
    }

    public Dish consoleBuilder(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter title:");
        String title = scan.next();
        System.out.println("Enter total calories capacity");
        while(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        Integer caloriesCapacity = scan.nextInt();
        System.out.println("Enter a link with recepy");
        String link = scan.next();
        System.out.println("Choose products to add:");
        ProductService productService = new ProductService();
        ArrayList<Product> products = productService.getAll();
        for (int i = 0; i < products.size()-1; i++) {
            System.out.println((i+1) + ". " + products.get(i).toString());
        }
        Integer num;
        HashMap<Product, Integer> ingredients = new HashMap<>();
        while(true){
            System.out.println("Enter numbers of ingredients to add, 0 to exit: ");
            num = scan.nextInt();
            Integer weight;
            if(num > 0 && num < products.size()){
                System.out.println("Enter a weight of product " + products.get(num-1).toString());
                weight = scan.nextInt();
                ingredients.put(products.get(num-1), weight);
            }
            else break;
        }
        return getDish(title, caloriesCapacity, ingredients, link);
    }
}
