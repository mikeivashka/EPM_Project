package by.epam.services;

import by.epam.collections.TrainingType;
import by.epam.dao.ProductDao;
import by.epam.entity.Activity;
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

    public boolean add(Product product){
        return  data.add(product);
    }

    public boolean update(String title, Integer caloriesCapacity){
        Integer index = getIndexByKey(title);
        if(index != -1){
            data.set(index, create(title, caloriesCapacity));
            return true;
        }
        return false;
    }

    public boolean update(Product product){
        Integer index = getIndexByKey(product.getTitle());
        if(index != -1){
            data.set(index, product);
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

    public Product consoleBuilder(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Title: ");
        String title = scan.next();
        System.out.println("Calories capacity per 100g");
        Integer caloriesCapacity = scan.nextInt();
        return create(title, caloriesCapacity);
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
                ArrayList<Product> data = getAll();
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
}
