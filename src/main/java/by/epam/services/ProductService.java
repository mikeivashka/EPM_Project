package by.epam.services;

import by.epam.dao.ProductDao;
import by.epam.entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;


public class ProductService implements Crudable<Product, ProductDao, String> {
    private static ProductDao dao = new ProductDao();
    private static Logger logger = LogManager.getLogger(System.in);
    @Override
    public Optional<Product> getEntityByKey(String s) {
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
    public boolean add(Product ob) {
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
    public ArrayList<Product> getAll() {
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
    public boolean update(Product entity) {
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
