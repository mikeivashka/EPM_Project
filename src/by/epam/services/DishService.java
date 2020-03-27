package by.epam.services;

import by.epam.collections.TrainingType;
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
        while(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        Integer caloriesCapacity = scan.nextInt();
        System.out.println("Enter a link with recepy");
        String link = scan.next();
        System.out.println("Choose products to add:");
        ProductService productService = new ProductService();
        ArrayList<Product> products = productService.getAll();
        while(true){

        }
        return create(title, id);
    }

}
