package by.epam.services;

import by.epam.dao.ProductDao;
import by.epam.entity.Product;

import java.net.Inet4Address;
import java.text.ParseException;
import java.util.Scanner;

public class ProductService{
    public boolean add(String title, String caloriesCapacity){
        Product product = new Product();
        product.setTitle(title);
        try{
        Integer capacity = Integer.parseInt(caloriesCapacity);
        }
        catch (NumberFormatException e){
            return false;
        }
        ProductDao dao = new ProductDao();
        dao.create(product);
        return true;
    }
}
