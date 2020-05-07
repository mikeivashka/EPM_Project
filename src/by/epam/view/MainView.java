package by.epam.view;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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
                default: break;
            }
        }
    }
}
