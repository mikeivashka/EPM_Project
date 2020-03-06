package by.epam.ui;

import by.epam.dao.ActivityController;

import java.io.IOException;
import java.util.Scanner;

import by.epam.entity.Activity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActivityUi extends Ui<ActivityController>{
    static Logger log = LogManager.getLogger();

    public void menu(){
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();

        switch(value){
            case 1:
                controller.create(object);
                break;
            case 2:
                controller.delete(object.getId());
                break;
            case 3:
                controller.getEntityById(object.getId());
                break;
            case 4:
                controller.update(object);
                break;
            case 5:
                controller.getAll();
                break;
            default:
                log.info("Enter another case");
                value = sc.nextInt();
        }
    }
}
