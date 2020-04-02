package by.epam.dao;

import by.epam.entity.Nutritionist;
import by.epam.entity.User;

public class NutritionistDao extends Dao<Nutritionist> {
    private static final String dir = "data/Nutritionist.dat";

    @Override
    public String getDir() {
        return dir;
    }
}
