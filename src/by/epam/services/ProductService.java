package by.epam.services;

import by.epam.dao.ProductDao;
import by.epam.entity.Product;

import java.net.Inet4Address;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductService extends Service<Product, String, ProductDao>{
    private Product create(String title, Integer caloriesCapacity){
        Product ob = new Product();
        ob.setTitle(title);
        ob.setCaloriesCapacity(caloriesCapacity);
        return ob;
    }

    public boolean add(String title, Integer caloriesCapacity){
        return data.add(this.create(title, caloriesCapacity));
    }

    public boolean update(String title, Integer caloriesCapacity){
        Integer index = getIndexByKey(title);
        if(index != -1){
            data.set(index, create(title, caloriesCapacity));
            return true;
        }
        return false;
    }

    public boolean delete(String title){
        Integer index = getIndexByKey(title);
        if(index != -1){
            data.remove(index);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getAll(){
        return data;
    }
}
