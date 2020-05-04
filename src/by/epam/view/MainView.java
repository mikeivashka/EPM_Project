package by.epam.view;

import by.epam.collections.TrainingType;
import by.epam.dao.db.ActivityDao;
import by.epam.dao.db.ProductDao;
import by.epam.entity.Activity;
import by.epam.entity.Product;

import java.sql.SQLException;
import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for(Product a : ProductDao.getAll()){
            System.out.println(a.toString());
        }
        Product product = new Product("Шоколад молочный", 270);
        try {
            ProductDao.update(product);
            ActivityDao.delete(6);
            ActivityDao.getEntityById(2).ifPresent(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Manager manager = new Manager();
        while(true){
            System.out.println("Choose what to manage: \n1.Activities\n2.Dishes\n3.Products\n4.Users\n5.Nutritionists\n0.Exit");
            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    manager.activityManager();
                    break;
                case 2:
                    manager.dishManager();
                    break;
                case 3:
                    manager.productManager();
                    break;
                case 4:
                    manager.baseUserManager();
                    break;
                case 5:
                    manager.nutritionistManager();
                    break;
                case 0:
                    System.exit(0);
                default: continue;
            }
        }
    }
}
