package by.epam.services.builders;

import by.epam.entity.Product;

import java.util.Scanner;

public class ProductBuilder {
    public static Product getProduct(String title, Integer caloriesCapacity){
        Product product = new Product();
        product.setCaloriesCapacity(caloriesCapacity);
        product.setTitle(title);
        return product;
    }

    public static Product consoleBuilder(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Title: ");
        String title = scan.next();
        System.out.println("Calories capacity per 100g");
        Integer caloriesCapacity = scan.nextInt();
        return getProduct(title, caloriesCapacity);
    }
}
