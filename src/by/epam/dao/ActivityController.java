package by.epam.dao;

import by.epam.entity.Activity;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ActivityController extends Controller<Activity, Integer> {

    private static final String dir = "data/activity.dat";


    public ActivityController() {
        super.initialize(dir);
    }

    @Override
    public Activity update(Activity entity) {
        for(Activity a : data){
            if(a.getId().equals(entity.getId()))a = entity;
            return a;
        }
        return null;
    }

    @Override
    public Activity getEntityById(Integer id) {
        for(Activity activity : data){
            if(activity.getId().equals(id))return activity;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        for(int i=0;i<data.size();i++) {
            if (data.get(i).getId() == id) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void create(Activity entity) throws IllegalArgumentException {
        if(getEntityById(entity.getId()) == null) {
            data.add(entity);
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
