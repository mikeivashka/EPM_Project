package by.epam.dao.db;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public abstract class Dao<E, K> {
    protected Connection connection;
    protected static Logger logger = LogManager.getLogger();

    public Dao() {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            connection = DriverManager.getConnection("jdbc:sqlite:database\\dietmanager.db");
        } catch (SQLException e) {
            logger.error("Cannot establish connection to database");
            logger.error(e);
            System.exit(-1);
        }
    }

    public abstract List<E> getAll();
    public abstract void update(E entity);
    public abstract Optional<E> getEntityById(K id) throws SQLException;
    public abstract void delete(K id) throws SQLException;
    public abstract void create (E entity) throws SQLException;

    protected PreparedStatement getPreparedStatement(String sql){
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            logger.error(e);
        }
        return null;
    }
}
