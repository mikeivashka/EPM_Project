package by.epam.dao.deprecated;

import by.epam.entity.Nutritionist;

public class NutritionistDao extends Dao<Nutritionist> {
    private static final String dir = "data/Nutritionist.dat";

    @Override
    public String getDir() {
        return dir;
    }
}
