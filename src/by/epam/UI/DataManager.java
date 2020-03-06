package by.epam.UI;

import by.epam.collections.TrainingType;
import by.epam.dao.ActivityController;
import by.epam.entity.Activity;

import java.util.Scanner;

public class DataManager {
    static Scanner scan = new Scanner(System.in);
    public void main(){
        while(true) {
            System.out.println("Choose what to manage: \n1.Activities\n2.Dishes\n3.Products\n4.Users\n0.Exit");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    activityManager();
                    break;
                }
                case 2:{
                    dishManager();
                    break;
                }
                case 3:{
                    productManager();
                    break;
                }
                case 4:{
                    userManager();
                    break;
                }
                case 0: return;
                default: continue;
            }
        }

    }
    private void activityManager(){
        ActivityController controller = new ActivityController();
        while(true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    controller.create(activityBuilder());
                    break;
                }
                case 2:{
                    System.out.println("Enter id to delete: ");
                    int id = scan.nextInt();
                    controller.delete(id);
                    break;
                }
                case 3:{
                    controller.update(activityBuilder());
                    break;
                }
                case 4:{
                    System.out.println(controller.getAll());
                    break;
                }
                case 0: main();
                default: continue;
            }
        }


    }
    private void dishManager(){

    }
    private void productManager(){

    }
    private void userManager(){

    }
    private Activity activityBuilder(){
        Activity ob = new Activity();
        System.out.println("ID:");
        ob.setId(scan.nextInt());
        System.out.println("Type (POWER or CARDIO)");
        ob.setType(TrainingType.valueOf(scan.next()));
        System.out.println("Description: ");
        ob.setDescription(scan.nextLine());
        System.out.println("Link for information: ");
        ob.setLink(scan.next());
        return ob;
    }
}
