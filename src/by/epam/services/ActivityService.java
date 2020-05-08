package by.epam.services;


import by.epam.dao.ActivityDao;
import by.epam.entity.Activity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class ActivityService implements Crudable<Activity, ActivityDao, Integer> {
    private static ActivityDao dao = new ActivityDao();
    private static Logger logger = LogManager.getLogger(System.in);
    @Override
    public Optional<Activity> getEntityByKey(Integer integer) {
        try{
            return dao.getEntityById(integer);
        }
        catch (SQLException e){
            logger.error("Error on database level");
            logger.error(e);
            return Optional.ofNullable(null);
        }

    }

    @Override
    public boolean add(Activity ob) {
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
    public ArrayList<Activity> getAll() {
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
    public boolean update(Activity entity) {
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
    public boolean delete(Integer integer) {
        try {
            dao.delete(integer);
            return true;
        }
        catch (SQLException e){
            logger.error("Error on database level");
            logger.error(e);
            return false;
        }
    }
}
