package by.epam.services;

import by.epam.dao.ActivityDao;
import by.epam.dao.NutritionistDao;
import by.epam.entity.Nutritionist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class NutritionistService implements Service<Nutritionist, NutritionistDao, String> {
    private static NutritionistDao dao = new NutritionistDao();
    private static Logger logger = LogManager.getLogger(System.in);
    @Override
    public Optional<Nutritionist> getEntityByKey(String s) {
        try{
            return dao.getEntityById(s);
        }
        catch (SQLException e){
            logger.error("Error on database level");
            logger.error(e);
            return Optional.ofNullable(null);
        }
    }

    @Override
    public boolean add(Nutritionist ob) {
        try {
            dao.create(ob);
            return true;
        }
        catch (SQLException e){
            logger.error("Error on database level");
            logger.error(e);
        }
        return false;
    }

    @Override
    public ArrayList<Nutritionist> getAll() {
        try {
            return dao.getAll();
        }
        catch (SQLException e){
            logger.error("Error on database level");
            logger.error(e);
            return new ArrayList<>();
        }
    }

    @Override
    public boolean update(Nutritionist entity) {
        try {
            dao.update(entity);
            return true;
        }
        catch (SQLException e){
            logger.error("Error on database level");
            logger.error(e);
            return false;
        }
    }

    @Override
    public boolean delete(String s) {
        try {
            dao.delete(s);
            return true;
        }
        catch (SQLException e){
            logger.error("Error on database level");
            logger.error(e);
            return false;
        }
    }
}
