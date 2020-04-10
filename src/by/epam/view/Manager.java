package by.epam.view;

import by.epam.entity.*;
import by.epam.services.*;
import by.epam.services.builders.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {
    private static Logger logger = LogManager.getLogger();
    private static Scanner scan;

    static {
        scan = new Scanner(System.in);
    }

    public void productManager(){

        ProductService productService = new ProductService();
        Integer choice;
        System.out.println("1. Create \n2. Update\n3. Delete \n4. Show all\n0. Exit");
        if(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        choice = scan.nextInt();
        switch (choice){
            case 1: {
                try {
                    productService.add(ProductBuilder.consoleBuilder());
                }catch (IOException e){
                    logger.error("En error occurred");
                }
                break;
            }

            case 2:{
                try {
                    productService.update(ProductBuilder.consoleBuilder());
                }catch (IOException e){
                    logger.error("En error occurred");
                }

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
        if(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        choice = scan.nextInt();
        switch (choice){
            case 1: {
                try {
                    new DishService().add(new DishBuilder().consoleBuilder());
                }catch (IOException e){
                    logger.error("En error occurred");
                }
                break;
            }

            case 2:{
                try {
                    new DishService().update(new DishBuilder().consoleBuilder());
                }catch (IOException e){
                    logger.error("En error occurred");
                }
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
        if(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        choice = scan.nextInt();
        switch (choice){
            case 1: {
                try{
                    new ActivityService().add(new ActivityBuilder().consoleBuilder());
                }
                catch (IOException e){
                    logger.error("En error occurred");
                }
                break;
            }

            case 2:{
                try {
                    new ActivityService().update(new ActivityBuilder().consoleBuilder());
                } catch (IOException e) {
                    logger.error("En error occurred");
                }
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
        if(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        choice = scan.nextInt();

        switch (choice){
            case 1:{
                try{
                    userService.add(new BaseUserBuilder().consoleBuilder());
                }catch (IOException e){
                    logger.error("Operation failed, try again later");
                }
                break;
            }
            case 2:{
                try{
                    userService.update(new BaseUserBuilder().consoleBuilder());
                }catch (IOException e){
                    logger.error("En error occurred");
                }
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
        try{
            choice = scan.nextInt();
        }
        catch (InputMismatchException e){
            logger.error("Incorrect input");
            return;
        }

        switch (choice){
            case 1:{
                try {
                    service.add(NutritionistBuilder.consoleBuilder());
                }catch (IOException e){
                    logger.error("En error occurred");
                }
                break;
            }
            case 2:{
                try {
                    service.update(NutritionistBuilder.consoleBuilder());
                }catch (IOException e){
                    logger.error("En error occurred");
                }

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
