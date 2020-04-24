package by.epam.services;

import by.epam.dao.deprecated.DishDao;
import by.epam.entity.Dish;
public class DishService extends Service<Dish, String, DishDao>{
    public DishService() {
        super.dao = new DishDao();
        super.data = dao.load();
    }
}
