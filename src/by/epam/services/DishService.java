package by.epam.services;

import by.epam.dao.DishDao;
import by.epam.entity.Activity;
import by.epam.entity.Dish;
import by.epam.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DishService extends Service<Dish, String, DishDao>{
    private Dish create(String title, Integer caloriesCapacity, String link, HashMap<Product, Integer> products){
        Dish ob = new Dish();
        ob.setTitle(title);
        ob.setCaloriesCapacity(caloriesCapacity);
        ob.setIngredients(products);
        ob.setRecepyLink(link);
        return  ob;
    }

    public boolean update(Dish ob){
        Integer index = getIndexByKey(ob.getTitle());
        if(index != -1){
            data.set(index, ob);
            return true;
        }
        return false;
    }

    public boolean add(String title, Integer caloriesCapacity, String link, HashMap<Product, Integer> products){
        return data.add(this.create(title, caloriesCapacity, link, products));
    }

    public boolean update(String title, Integer caloriesCapacity, String link, HashMap<Product, Integer> products){
        Integer index = this.getIndexByKey(title);
        if(index!= -1)data.set(index, create(title, caloriesCapacity, link, products));
        else return false;
        return true;
    }

    public boolean delete(String title){
        Integer index = this.getIndexByKey(title);
        if(index != -1)data.remove(index);
        else return false;
        return true;
    }

    public ArrayList<Dish> getAll(){
        return data;
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
        return create(title, caloriesCapacity, link, ingredients);
    }

    public void consoleManager(){
        Scanner scan = new Scanner(System.in);
        Integer choice;
        System.out.println("1. Create \n2. Update\n3. Delete \n4. Show all\n0. Exit");
        while(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        choice = scan.nextInt();
        switch (choice){
            case 1: {
                add(consoleBuilder());
                break;
            }

            case 2:{
                update(consoleBuilder());
                break;
            }

            case 3:{
                System.out.println("Enter title to delete");
                String title = scan.next();
                if(delete(title)) {
                    System.out.println("Success");
                }
                else {
                    System.out.println("Delete failed");
                }
                break;
            }

            case 4:{
                ArrayList<Dish> data = getAll();
                for(Dish e : data){
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
