package by.epam.services;

import by.epam.collections.ActivityLevel;
import by.epam.collections.TrainingType;
import by.epam.dao.ActivityDao;
import by.epam.dao.Dao;
import by.epam.entity.Activity;
import by.epam.entity.Dish;

import java.util.ArrayList;

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
        return dao.delete(id);
    }

    public ArrayList<Activity> getAll(){
        return dao.getAll();
    }
}
