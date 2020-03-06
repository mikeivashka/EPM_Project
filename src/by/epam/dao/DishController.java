package by.epam.dao;
import by.epam.entity.Dish;

    public class DishController extends Controller<Dish, String> {
        private static final String dir = "data/dish.dat";
        public DishController() {
            super.initialize(dir);
        }
    }

