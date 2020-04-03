package by.epam.view;

import by.epam.entity.*;
import by.epam.services.*;
import by.epam.services.builders.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Manager {
    static Logger logger = LogManager.getLogger();
    static Scanner scan;

    static {
        scan = new Scanner(System.in);
    }

    public void productManager(){

        ProductService productService = new ProductService();
        Integer choice;
        System.out.println("1. Create \n2. Update\n3. Delete \n4. Show all\n0. Exit");
        while(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        choice = scan.nextInt();
        switch (choice){
            case 1: {
                productService.add(ProductBuilder.consoleBuilder());
                break;
            }

            case 2:{
                productService.update(ProductBuilder.consoleBuilder());
                break;
            }

            case 3:{
                System.out.println("Enter title to delete");
                String title = scan.next();
                if(productService.delete(title)) {
                    logger.info("Object Deleted successfully");
                }
                else {
                    logger.info("Delete failed");
                }
                break;
            }

            case 4:{
                ArrayList<Product> data = productService.getAll();
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

    public void baseUserManager() {
        Integer choice;
        BaseUserService userService = new BaseUserService();
        System.out.println("1. Create \n2. Update\n3. Delete \n4. Show all\n0. Exit");
        while(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        choice = scan.nextInt();

        switch (choice){
            case 1:{
                userService.add(new BaseUserBuilder().consoleBuilder());
                break;
            }
            case 2:{
                userService.update(new BaseUserBuilder().consoleBuilder());
                break;
            }
            case 3:{
                System.out.println("Enter email to delete");
                String email = scan.next();
                if(userService.delete(email)) {
                    System.out.println("Success");
                }
                else {
                    System.out.println("Delete failed");
                }
                break;
            }
            case 4:{
                ArrayList<BaseUser> users = userService.getAll();
                for(BaseUser e : users){
                    System.out.println(e.toString());
                }
                break;
            }
            default:
                return;
        }
    }

    public void nutritionistManager() {
        Integer choice;
        NutritionistService service = new NutritionistService();
        System.out.println("1. Create \n2. Update\n3. Delete \n4. Show all\n0. Exit");
        while(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        choice = scan.nextInt();

        switch (choice){
            case 1:{
                service.add(NutritionistBuilder.consoleBuilder());
                break;
            }
            case 2:{
                service.update(NutritionistBuilder.consoleBuilder());
                break;
            }
            case 3:{
                System.out.println("Enter email to delete");
                String email = scan.next();
                if(service.delete(email)) {
                    System.out.println("Success");
                }
                else {
                    System.out.println("Delete failed");
                }
                break;
            }
            case 4:{
                ArrayList<Nutritionist> data = service.getAll();
                for(Nutritionist e : data){
                    System.out.println(e.toString());
                }
                break;
            }
            default: return;
        }
    }
}
