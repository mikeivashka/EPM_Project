package by.epam.dao;
import by.epam.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public abstract class Dao<E extends Entity, K> {
    protected static Connection connection;
    protected static Logger logger = LogManager.getLogger();
    static {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            connection = DriverManager.getConnection("jdbc:sqlite:database\\dietmanager.db");
        } catch (SQLException e) {
            logger.error("Cannot establish connection to database");
            logger.error(e);
            System.exit(-1);
        }
    }

    public abstract void update(E entity) throws SQLException;
    public abstract void delete(K key) throws SQLException;
    public abstract ArrayList<E> getAll() throws SQLException;
    public abstract void create(E entity) throws SQLException;
    public abstract Optional<E> getEntityById(K key) throws SQLException;
}
