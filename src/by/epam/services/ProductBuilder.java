package by.epam.services;

import by.epam.entity.Product;

import java.util.Scanner;

public class ProductBuilder {
    public Product ProductBuilder(String title, Integer caloriesCapacity) {
        return getProduct(title, caloriesCapacity);
    }

    public Product PruductBuilder(){
        return new Product();
    }

    public static Product getProduct(String title, Integer caloriesCapacity){
        Product product = new Product();
        product.setCaloriesCapacity(caloriesCapacity);
        product.setTitle(title);
        return product;
    }

    public Product consoleBuilder(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Title: ");
        String title = scan.next();
        System.out.println("Calories capacity per 100g");
        Integer caloriesCapacity = scan.nextInt();
        return getProduct(title, caloriesCapacity);
    }
}
