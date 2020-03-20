package by.epam.services;

import by.epam.entity.Product;

import java.util.Scanner;

public class ProductBuilder {
    static Scanner scan = new Scanner(System.in);

    public static Product productBuilder(){
        System.out.println("Title: ");
        String pTitle = scan.next();
        System.out.println("Calories Capacity: ");
        int pCalories = scan.nextInt();
        Product product = new Product(pTitle, pCalories);
        return product;
    }
}
