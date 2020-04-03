package by.epam.services;

import by.epam.dao.NutritionistDao;import by.epam.entity.Nutritionist;
import by.epam.entity.User;

import java.util.*;

public class NutritionistService extends Service<Nutritionist, String, NutritionistDao> {
    public NutritionistService() {
        super.dao = new NutritionistDao();
        super.data = dao.load();
    }
}
