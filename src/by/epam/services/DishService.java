package by.epam.services;

import by.epam.dao.DishDao;
import by.epam.entity.Dish;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class DishService implements Crudable<Dish, DishDao, String> {
    private static DishDao dao = new DishDao();
    private static Logger logger = LogManager.getLogger(System.in);
    @Override
    public Optional<Dish> getEntityByKey(String s) {
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
    public boolean add(Dish ob) {
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
    public ArrayList<Dish> getAll() {
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
    public boolean update(Dish entity) {
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
