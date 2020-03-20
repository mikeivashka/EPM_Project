package by.epam.services;

import by.epam.dao.DishDao;
import by.epam.entity.Dish;
import by.epam.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class DishService {
    private static DishDao dao;

    public static boolean add(String title, String caloriesCapacity, String link, HashMap<Product, Integer> products){
        Dish dish = new Dish();
        dish.setTitle(title);
        Integer capacity;
        try{
            capacity = Integer.parseInt(caloriesCapacity);
        }
        catch (NumberFormatException e){
            return false;
        }
        dish.setCaloriesCapacity(capacity);
        dish.setIngredients(products);
        dish.setRecepyLink(link);
        dao.create(dish);
        return true;
    }

    public static boolean update(String title, String caloriesCapacity, String link, HashMap<Product, Integer> products){
        Dish dish = new Dish();
        dish.setTitle(title);
        Integer capacity;
        try{
            capacity = Integer.parseInt(caloriesCapacity);
        }
        catch (NumberFormatException e){
            return false;
        }
        dish.setCaloriesCapacity(capacity);
        dish.setIngredients(products);
        dish.setRecepyLink(link);
        dao.update(dish);
        return true;
    }

    public static boolean delete(String title){
        return dao.delete(title);
    }

    public static ArrayList<Dish> getAll(){
        return dao.getAll();
    }
}
