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
    public List<Activity> getAll() {
        return null;
    }

    @Override
    public Activity update(Activity entity) {
        return null;
    }

    @Override
    public Activity getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Activity entity) {
        return false;
    }
}
