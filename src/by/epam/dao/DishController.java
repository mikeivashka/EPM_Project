package by.epam.dao;

import by.epam.entity.Dish;

import java.util.List;

public class DishController extends Controller<Dish, String> {
    private static final String dir = "data/Dish.dat";

    public DishController() {
        super.initialize(dir);
    }

    @Override
    public List<Dish> getAll() {
        return null;
    }

    @Override
    public Dish update(Dish entity) {
        return null;
    }

    @Override
    public Dish getEntityById(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean create(Dish entity) {
        return false;
    }
}
