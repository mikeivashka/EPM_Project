package by.epam.services;

import by.epam.dao.DishDao;
import by.epam.entity.Dish;
import by.epam.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;

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

    public static boolean update(String title, Integer caloriesCapacity, String link, HashMap<Product, Integer> products){
        data.
        return true;
    }

    public static boolean delete(String title){
        return dao.delete(title);
    }

    public static ArrayList<Dish> getAll(){
        return dao.getAll();
    }
}
