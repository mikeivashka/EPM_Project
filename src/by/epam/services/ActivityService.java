package by.epam.services;

import by.epam.collections.ActivityLevel;
import by.epam.collections.TrainingType;
import by.epam.dao.ActivityDao;
import by.epam.dao.Dao;
import by.epam.entity.Activity;
import by.epam.entity.Dish;

import java.util.ArrayList;

public class ActivityService extends Service<Activity, String, Dao<Activity, String>>{

    private Activity create(Integer id, TrainingType type, String description, String link){
        Activity result = new Activity();
        result.setLink(link);
        result.setId(id);
        result.setDescription(description);
        result.setType(type);
        return result;
    }

    public boolean add(String id, String type, String description, String link){
        Integer parsedId;
        TrainingType parsedType;
        try{
            parsedId = Integer.parseInt(id);
        }
        catch (NumberFormatException e){
            return false;
        }
        try{
            parsedType = TrainingType.valueOf(type.toUpperCase());
        }catch(EnumConstantNotPresentException e){
            return false;
        }

        this.data.add(create(parsedId, parsedType, description, link));
        return true;
    }

    public boolean update(String id, String type, String description, String link){
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
