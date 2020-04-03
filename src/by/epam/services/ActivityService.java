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
    public ActivityService() {
        super.dao = new ActivityDao();
        super.data = dao.load();
    }
}
