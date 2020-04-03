package by.epam.services.builders;

import by.epam.entity.Product;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class ProductBuilder {
    static Logger log = LogManager.getLogger();

    public static Product getProduct(String title, Integer caloriesCapacity){
        Product product = new Product();
        product.setCaloriesCapacity(caloriesCapacity);
        product.setTitle(title);
        return product;
    }

    public static Product consoleBuilder() throws IOException {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Title: ");
            String title = scan.next();
            System.out.println("Calories capacity per 100g");
            Integer caloriesCapacity = scan.nextInt();
            return getProduct(title, caloriesCapacity);
        }catch (Exception e){
            log.log(Level.ERROR, "Failed to create object");
            throw new IOException();
        }
    }
}
