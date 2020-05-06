package by.epam.dao.db;
import by.epam.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;
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
}
