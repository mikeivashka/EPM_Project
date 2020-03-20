package by.epam.services;

import by.epam.dao.ProductDao;
import by.epam.entity.Product;

import java.net.Inet4Address;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductService{
    private static ProductDao dao;

    public static boolean add(String title, String caloriesCapacity){
        Product product = new Product();
        product.setTitle(title);
        try{
        Integer capacity = Integer.parseInt(caloriesCapacity);
        }
        catch (NumberFormatException e){
            return false;
        }
        dao.create(product);
        return true;
    }

    public static boolean update(String title, String caloriesCapacity){
        Product product = new Product();
        product.setTitle(title);
        try{
            Integer capacity = Integer.parseInt(caloriesCapacity);
        }
        catch (NumberFormatException e){
            return false;
        }
        dao.update(product);
        return true;
    }

    public static boolean delete(String title){
        return dao.delete(title);
    }

    public static ArrayList<Product> getAll(){
        return dao.getAll();
    }


}
