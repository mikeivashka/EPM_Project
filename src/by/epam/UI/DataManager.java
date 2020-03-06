package by.epam.UI;

import by.epam.collections.ActivityLevel;
import by.epam.collections.TrainingType;
import by.epam.dao.*;
import by.epam.entity.Activity;
import by.epam.entity.Dish;
import by.epam.entity.Product;
import by.epam.entity.User;

import java.util.*;

public class DataManager {
    static Scanner scan = new Scanner(System.in);
    public static void main(String args[]){
        while(true) {
            System.out.println("Choose what to manage: \n1.Activities\n2.Dishes\n3.Products\n4.Users\n0.Exit1");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    activityManager();
                    break;
                }
                case 2:{
                    dishManager();
                    break;
                }
                case 3:{
                    productManager();
                    break;
                }
                case 4:{
                    userManager();
                    break;
                }
                case 0: System.exit(0);
                default: continue;
            }
        }

    }
    private static void activityManager(){
        ActivityController controller = new ActivityController();
        controller.load();
        while(true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    controller.create(activityBuilder());
                    break;
                }
                case 2:{
                    System.out.println("Enter id to delete: ");
                    int id = scan.nextInt();
                    controller.delete(id);
                    break;
                }
                case 3:{
                    controller.update(activityBuilder());
                    break;
                }
                case 4:{
                    System.out.println(controller.getAll());
                    break;
                }
                case 0: {
                    controller.save();
                    main(new String[0]);
                };
                default: continue;
            }



        }

    }
    private static void dishManager(){
        DishController controller = new DishController();
        controller.load();
        while(true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    controller.create(dishBuilder());
                    break;
                }
                case 2:{
                    System.out.println("Enter id to delete: ");
                    String dTitle = scan.nextLine();
                    controller.delete(dTitle);
                    break;
                }
                case 3:{
                    controller.update(dishBuilder());
                    break;
                }
                case 4:{
                    System.out.println(controller.getAll());
                    break;
                }
                case 0: {
                    controller.save();
                    main(new String[0]);
                }
                default: continue;
            }


        }

    }
    private static void productManager(){
        ProductController controller = new ProductController();
        controller.load();
        while(true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    controller.create(productBuilder());
                    break;
                }
                case 2:{
                    System.out.println("Enter id to delete: ");
                    String pTitle = scan.nextLine();
                    controller.delete(pTitle);
                    break;
                }
                case 3:{
                    controller.update(productBuilder());
                    break;
                }
                case 4:{
                    System.out.println(controller.getAll());
                    break;
                }
                case 0: {
                    controller.save();
                    main(new String[0]);
                }
                default: continue;
            }


        }
    }
    private static void userManager(){
        UserController controller = new UserController();
        while(true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    controller.create(userBuilder());
                    break;
                }
                case 2:{
                    System.out.println("Enter Email to delete: ");
                    String pEmail = scan.nextLine();
                    controller.delete(pEmail);
                    break;
                }
                case 3:{
                    controller.update(userBuilder());
                    break;
                }
                case 4:{
                    System.out.println(controller.getAll());
                    break;
                }
                case 0: {
                    controller.save();
                    main(new String[0]);}
                default: continue;
            }


        }
    }
    private static Activity activityBuilder(){
        Activity ob = new Activity();
        System.out.println("ID:");
        ob.setId(scan.nextInt());
        System.out.println("Type (POWER or CARDIO)");
        ob.setType(TrainingType.valueOf(scan.next()));
        System.out.println("Description: ");
        ob.setDescription(scan.next());
        System.out.println("Link for information: ");
        ob.setLink(scan.next());
        return ob;
    }
    private static Dish dishBuilder(){
        Dish ob = new Dish();
        System.out.println("Title: ");
        ob.setTitle(scan.nextLine());
        System.out.println("Calories:");
        ob.setCaloriesCapacity(scan.nextInt());
        System.out.println("Ingredients: ");

        Map<Product, Integer> tmp = new HashMap<Product, Integer>();
        System.out.println("Ingredient name:");
        String mStr = scan.nextLine();
        System.out.println("Ingredient weight");
        int mGr = scan.nextInt();
        tmp.put(productBuilder(),mGr);
        ob.setIngredients(tmp);

        System.out.println("Recepy Link:");
        ob.setRecepyLink(scan.nextLine());
        return ob;
    }
    private static Product productBuilder(){
        System.out.println("Title: ");
        String pTitle = scan.nextLine();
        System.out.println("Calories Capacity: ");
        int pCalories = scan.nextInt();
        Product product = new Product(pTitle, pCalories);
        return product;
    }
    private static User userBuilder(){
        User user = new User();
        System.out.println("Email: ");
        user.setEmail(scan.nextLine());
        System.out.println("Name: ");
        user.setName(scan.nextLine());
        System.out.println("Surname: ");
        user.setSurname(scan.nextLine());
        System.out.println("Activity level (NONE, SEDENTARY, LIGHTLY_ACTIVE, MODERATELY_ACTIVE, VERY_ACTIVE)");
        new User.UserBaseData().setActivityLevel(ActivityLevel.valueOf(scan.next()));
        return user;
    }
}
