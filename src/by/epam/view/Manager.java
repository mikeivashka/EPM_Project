package by.epam.view;

import by.epam.entity.Activity;
import by.epam.entity.Dish;
import by.epam.entity.Product;
import by.epam.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    static Logger logger = LogManager.getLogger();
    public void productManager(){
        Scanner scan = new Scanner(System.in);
        Integer choice;
        System.out.println("1. Create \n2. Update\n3. Delete \n4. Show all\n0. Exit");
        while(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        choice = scan.nextInt();
        switch (choice){
            case 1: {
                new ProductService().add(new ProductBuilder().consoleBuilder());
                break;
            }

            case 2:{
                new ProductService().update(new ProductBuilder().consoleBuilder());
                break;
            }

            case 3:{
                System.out.println("Enter title to delete");
                String title = scan.next();
                if(new ProductService().delete(title)) {
                    logger.info("Object Deleted successfully");
                }
                else {
                    logger.info("Delete failed");
                }
                break;
            }

            case 4:{
                ArrayList<Product> data = new ProductService().getAll();
                for(Product e : data){
                    System.out.println(e.toString());
                }
                break;
            }
            default:{
                return;
            }
        }
    }

    public void dishManager(){
        Scanner scan = new Scanner(System.in);
        Integer choice;
        System.out.println("1. Create \n2. Update\n3. Delete \n4. Show all\n0. Exit");
        while(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        choice = scan.nextInt();
        switch (choice){
            case 1: {
                new DishService().add(new DishBuilder().consoleBuilder());
                break;
            }

            case 2:{
                new DishService().update(new DishBuilder().consoleBuilder());
                break;
            }

            case 3:{
                System.out.println("Enter title to delete");
                String title = scan.next();
                if(new DishService().delete(title)) {
                    logger.info("Object Deleted successfully");
                }
                else {
                    logger.error("Delete failed");
                }
                break;
            }

            case 4:{
                ArrayList<Dish> data = new DishService().getAll();
                for(Dish e : data) {
                    System.out.println(e.toString());
                }
                break;
            }
            default:{
                return;
            }
        }
    }

    public void activityManager(){
        Scanner scan = new Scanner(System.in);
        Integer choice;
        System.out.println("1. Create \n2. Update\n3. Delete \n4. Show all\n0. Exit");
        while(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        choice = scan.nextInt();
        switch (choice){
            case 1: {
                new ActivityService().add(new ActivityBuilder().consoleBuilder());
                break;
            }

            case 2:{
                new ActivityService().update(new ActivityBuilder().consoleBuilder());
                break;
            }

            case 3:{
                System.out.println("Enter id to delete");
                while(!scan.hasNextInt()){
                    System.out.println("Waiting for integer value");
                }
                Integer id = scan.nextInt();
                if(new ActivityService().delete(id)) {
                    logger.info("Object Deleted successfully");
                }
                else {
                    logger.error("Delete failed");
                }
                break;
            }

            case 4:{
                ArrayList<Activity> data = new ActivityService().getAll();
                for(Activity e : data){
                    System.out.println(e.toString());
                }
                break;
            }
            default:{
                return;
            }
        }
    }
}
