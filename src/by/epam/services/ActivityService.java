package by.epam.services;

import by.epam.collections.TrainingType;
import by.epam.dao.ActivityDao;
import by.epam.entity.Activity;
import by.epam.entity.Dish;

import java.util.ArrayList;

public class ActivityService {
    public static ActivityDao dao;

    public static boolean add(String id, String type, String description, String link){
        Activity ob = new Activity();
        Integer obId;
        try{
            obId = Integer.parseInt(id);
        }
        catch (NumberFormatException e){
            return false;
        }
        try{
            ob.setType(TrainingType.valueOf(type.toUpperCase()));
        }catch(EnumConstantNotPresentException e){
            return false;
        }
        ob.setDescription(description);
        ob.setLink(link);
        dao.create(ob);
        return true;
    }

    public static boolean update(String id, String type, String description, String link){
        Activity ob = new Activity();
        Integer obId;
        try{
            obId = Integer.parseInt(id);
        }
        catch (NumberFormatException e){
            return false;
        }
        try{
            ob.setType(TrainingType.valueOf(type.toUpperCase()));
        }catch(EnumConstantNotPresentException e){
            return false;
        }
        ob.setDescription(description);
        ob.setLink(link);
        dao.update(ob);
        return true;
    }

    public static boolean delete(String id){
        Integer obId;
        try{
            obId = Integer.parseInt(id);
        }
        catch (NumberFormatException e){
            return false;
        }
        return dao.delete(obId);
    }

    public static ArrayList<Activity> getAll(){
        return dao.getAll();
    }
}
