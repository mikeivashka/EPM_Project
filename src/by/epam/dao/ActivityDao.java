package by.epam.dao;

import by.epam.entity.Activity;

public class ActivityDao extends Dao<Activity, Integer> {
    private static final String dir = "data/activity.dat";

    @Override
    public String getDir() {
        return dir;
    }
}