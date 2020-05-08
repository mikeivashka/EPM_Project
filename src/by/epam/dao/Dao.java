package by.epam.dao;
import by.epam.entity.Entity;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public abstract class Dao<E extends Entity, K> {
    protected static Logger logger = LogManager.getLogger();
    private static BasicDataSource ds = new BasicDataSource();
    static {
        ds.setUrl("jdbc:sqlite:database\\dietmanager.db");
        ds.setMaxOpenPreparedStatements(100);
    }

    protected static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public abstract void update(E entity) throws SQLException;
    public abstract void delete(K key) throws SQLException;
    public abstract ArrayList<E> getAll() throws SQLException;
    public abstract void create(E entity) throws SQLException;
    public abstract Optional<E> getEntityById(K key) throws SQLException;
}
