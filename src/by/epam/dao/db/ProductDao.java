package by.epam.dao.db;

import by.epam.collections.TrainingType;
import by.epam.entity.Activity;
import by.epam.entity.Product;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ProductDao extends Dao<Product, String> {
    private static final String SELECT_ALL = "SELECT * FROM products";
    private static final String INSERT_FULL = "INSERT INTO products VALUES(?, ?)";
    private static final String DELETE = "DELETE FROM products where title = ?";
    private static final String GET_BY_ID = "SELECT * FROM products where title = ?";
    private static final String UPDATE = "UPDATE products SET calories_capacity = ? WHERE title = ?";

    public static void update(@NotNull Product product) {
        try {
            var statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, product.getCaloriesCapacity());
            statement.setString(2, product.getTitle());
            statement.execute();
        }
        catch (SQLException e){
            logger.error(e);
        }
    }

    public static Optional<Product> getEntityById(@NotNull String id) throws SQLException{
        var statement = connection.prepareStatement(GET_BY_ID);
        statement.setString(1, id);
        var resultSet = statement.executeQuery();
        Product product = null;
        if(!resultSet.isClosed()) product = new Product(
                resultSet.getString(1),
                resultSet.getInt(2));
        return Optional.ofNullable(product);
    }

    public static void delete(@NotNull String id) throws SQLException{
        var statement = connection.prepareStatement(DELETE);
        statement.setString(1, id);
        statement.execute();
    }

    public static void create(@NotNull Product entity) throws SQLException{
        var statement = connection.prepareStatement(INSERT_FULL);
        statement.setString(1, entity.getTitle());
        statement.setInt(2, entity.getCaloriesCapacity());
        statement.execute();
    }

    public static List<Product> getAll() {
        var result = new LinkedList<Product>();
        try (var statement = connection.createStatement()) {
            var resultSet = statement.executeQuery(SELECT_ALL);
            while(resultSet.next()){
                result.add(
                        new Product(
                                resultSet.getString(1),
                                resultSet.getInt(2)
                        )
                );
            }
        }
        catch (SQLException e){
            logger.error("Failed to execute statement");
            logger.error(e);
        }
        return result;

    }
}

