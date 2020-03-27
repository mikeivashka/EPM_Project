package by.epam.dao;
import by.epam.entity.Dish;

    public class DishDao extends Dao<Dish> {
        private static final String dir = "data/dish.dat";

        @Override
        public String getDir() {
            return dir;
        }
    }

