package by.epam.services;

import by.epam.collections.ActivityLevel;
import by.epam.collections.TrainingType;
import by.epam.dao.ActivityDao;
import by.epam.dao.Dao;
import by.epam.entity.Activity;
import by.epam.entity.Dish;

import java.util.ArrayList;
import java.util.Scanner;

public class ActivityService extends Service<Activity, Integer, ActivityDao>{

    private Activity create(Integer id, TrainingType type, String description, String link){
        Activity result = new Activity();
        result.setLink(link);
        result.setId(id);
        result.setDescription(description);
        result.setType(type);
        return result;
    }

    public boolean add(Integer id, TrainingType type, String description, String link){
        return data.add(this.create(id,type,description,link));
    }

    public boolean update(Integer id, TrainingType type, String description, String link){

        Integer index = this.getIndexByKey(id);
        if(index != -1){
            data.set(index, create(id,type,description,link));
            return true;
        }
        return false;
    }

    public boolean delete(Integer id){
        Integer index = getIndexByKey(id);
        if(index != -1){
            data.remove(index);
            return true;
        }
        else return false;
    }

    public ArrayList<Activity> getAll(){
        return data;
    }

    public Activity consoleBuilder(){
        Scanner scan = new Scanner(System.in);
        System.out.println("id (integer): ");
        Integer id = scan.nextInt();
        System.out.println("training type (1 - POWER, 2 - CARDIO, default - CARDIO)");
        TrainingType trainingType;
        switch (scan.nextInt()){
            case 1:{
                trainingType = TrainingType.POWER;
                break;
            }
            case 2:{
                trainingType = TrainingType.CARDIO;
                break;
            }
            default: {
                trainingType = TrainingType.CARDIO;
                break;
            }
        }
        System.out.println("Enter a description line: ");
        String description = scan.next();
        System.out.println("Enter a link with activity description: ");
        String link = scan.next();
        return create(id, trainingType, description, link);
    }
}
