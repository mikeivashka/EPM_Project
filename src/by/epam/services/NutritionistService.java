package by.epam.services;

import by.epam.dao.deprecated.NutritionistDao;import by.epam.entity.Nutritionist;

public class NutritionistService extends Service<Nutritionist, String, NutritionistDao> {
    public NutritionistService() {
        super.dao = new NutritionistDao();
        super.data = dao.load();
    }
}
