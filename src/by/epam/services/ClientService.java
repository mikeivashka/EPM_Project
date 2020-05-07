package by.epam.services;

import by.epam.dao.ClientDao;
import by.epam.entity.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class ClientService implements Service<Client, ClientDao, String> {
    private static ClientDao dao = new ClientDao();
    private static Logger logger = LogManager.getLogger(System.in);

    @Override
    public Optional<Client> getEntityByKey(String key) {
        try{
            return dao.getEntityById(key);
        }
        catch (SQLException e){
            logger.error("Error on database level");
            logger.error(e);
            return Optional.ofNullable(null);
        }
    }

    @Override
    public boolean add(Client ob) {
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
    public ArrayList<Client> getAll() {
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
    public boolean update(Client entity) {
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
    public boolean delete(String key) {
        try {
            dao.delete(key);
            return true;
        }
        catch (SQLException e){
            logger.error("Error on database level");
            logger.error(e);
            return false;
        }
    }
}
