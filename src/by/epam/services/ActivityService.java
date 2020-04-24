package by.epam.services;

import by.epam.dao.deprecated.ActivityDao;
import by.epam.entity.Activity;

public class ActivityService extends Service<Activity, Integer, ActivityDao>{
    public ActivityService() {
        super.dao = new ActivityDao();
        super.data = dao.load();
    }
}
