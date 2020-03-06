package by.epam.dao;

import by.epam.entity.Activity;

public class ActivityController extends Controller<Activity, Integer> {
    private static final String dir = "data/activity.dat";
    public ActivityController() {
        super.initialize(dir);
    }
}
