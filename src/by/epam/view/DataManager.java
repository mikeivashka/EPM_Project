package by.epam.view;

import by.epam.collections.ActivityLevel;
import by.epam.collections.TrainingType;
import by.epam.dao.*;
import by.epam.entity.*;
import by.epam.entity.User;
import by.epam.entity.BaseUser;

import java.io.IOException;
import java.util.*;

public class DataManager {
    static Scanner scan = new Scanner(System.in);
    public static void main(String args[]){
        while(true) {
            System.out.println("Choose what to manage: \n1.Activities\n2.Dishes\n3.Products\n4.Users\n0.Exit");
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
        ActivityDao dao = new ActivityDao();
        dao.load();
        while(true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    dao.create(activityBuilder());
                    break;
                }
                case 2:{
                    System.out.println("Enter id to delete: ");
                    int id = scan.nextInt();
                    dao.delete(id);
                    break;
                }
                case 3:{
                    dao.update(activityBuilder());
                    break;
                }
                case 4:{
                    System.out.println(dao.getAll());
                    break;
                }
                case 0: {
                    dao.save();
                    main(new String[0]);
                };
                default: continue;
            }

        }

    }
    private static void dishManager(){
        DishDao dao = new DishDao();
        dao.load();
        while(true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    dao.create(dishBuilder());
                    break;
                }
                case 2:{
                    System.out.println("Enter id to delete: ");
                    String dTitle = scan.nextLine();
                    dao.delete(dTitle);
                    break;
                }
                case 3:{
                    dao.update(dishBuilder());
                    break;
                }
                case 4:{
                    System.out.println(dao.getAll());
                    break;
                }
                case 0: {
                    dao.save();
                    main(new String[0]);
                }
                default: continue;
            }

        }

    }
    private static void productManager(){
        ProductDao dao = new ProductDao();
        dao.load();
        while(true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    dao.create(productBuilder());
                    break;
                }
                case 2:{
                    System.out.println("Enter title to delete: ");
                    String pTitle = scan.next();
                    dao.delete(pTitle);
                    break;
                }
                case 3:{
                    dao.update(productBuilder());
                    break;
                }
                case 4:{
                    System.out.println(dao.getAll());
                    break;
                }
                case 0: {
                    dao.save();
                    main(new String[0]);
                }
                default: continue;
            }


        }
    }
    private static void userManager(){
        UserDao dao = new UserDao();
        while(true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    dao.create(userBuilder());
                    break;
                }
                case 2:{
                    System.out.println("Enter Email to delete: ");
                    String pEmail = scan.nextLine();
                    dao.delete(pEmail);
                    break;
                }
                case 3:{
                    dao.update(userBuilder());
                    break;
                }
                case 4:{
                    System.out.println(dao.getAll());
                    break;
                }
                case 0: {
                    dao.save();
                    main(new String[0]);}
                default: continue;
            }


        }
    }
    //не работает update
    private static Activity activityBuilder(){
        Activity ob = new Activity();
        System.out.println("ID:");
        ob.setId(scan.nextInt());
        System.out.println("Type (POWER or CARDIO): ");
        ob.setType(TrainingType.valueOf(scan.next().toUpperCase()));
        System.out.println("Description: ");
        ob.setDescription(scan.next());
        System.out.println("Link for information: ");
        ob.setLink(scan.next());
        return ob;
    }
    //не работает вообще
    private static Dish dishBuilder(){
        Dish ob = new Dish();
        System.out.println("Title: \n");
        ob.setTitle(scan.nextLine());
        System.out.println("Calories:");
        ob.setCaloriesCapacity(scan.nextInt());
        System.out.println("Ingredients: ");

        Map<Product, Integer> tmp = new HashMap<>();
        System.out.println("Ingredient weight");
        int mGr = scan.nextInt();
        tmp.put(productBuilder(),mGr);
        ob.setIngredients(tmp);

        System.out.println("Recepy Link:");
        ob.setRecepyLink(scan.nextLine());
        return ob;
    }
    //не работает update
    private static Product productBuilder(){
        System.out.println("Title: ");
        String pTitle = scan.next();
        System.out.println("Calories Capacity: ");
        int pCalories = scan.nextInt();
        Product product = new Product(pTitle, pCalories);
        return product;
    }
    //работает некорректно
    private static User userBuilder(){
        BaseUser user = new BaseUser();
        System.out.println("Email: ");
        user.setEmail(scan.nextLine());
        System.out.println("Name: ");
        user.setName(scan.nextLine());
        System.out.println("Surname: ");
        user.setSurname(scan.nextLine());
        System.out.println("Activity level (NONE, SEDENTARY, LIGHTLY_ACTIVE, MODERATELY_ACTIVE, VERY_ACTIVE)");
        user.setActivityLevel(ActivityLevel.valueOf(scan.next().toUpperCase()));
        return user;
    }
}
