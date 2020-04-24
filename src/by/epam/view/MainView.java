package by.epam.view;

import by.epam.collections.TrainingType;
import by.epam.dao.db.ActivityDao;
import by.epam.entity.Activity;

import java.sql.SQLException;
import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ActivityDao dao = new ActivityDao();
        for(Activity a : dao.getAll()){
            System.out.println(a.toString());
        }
        Activity activity = new Activity(0, TrainingType.CARDIO, "Ваша первая утренняя пробежка", "http://www.stylefitness.ru/gayd-beg-dlya-nachinayushchikh.html");
        try {
            dao.update(activity);
            dao.delete(6);
            dao.getEntityById(2).ifPresent(System.out::println);
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
