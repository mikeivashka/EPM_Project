package by.epam.dao.deprecated;

import by.epam.entity.Activity;

public class ActivityDao extends Dao<Activity> {
    private static final String dir = "data/activity.dat";

    @Override
    public String getDir() {
        return dir;
    }
}