package by.epam.dao.db;

import by.epam.entity.Dish;
import by.epam.entity.Product;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class DishDao extends Dao<Dish, String> {
    private static final String SELECT_ALL_DISHES = "SELECT * FROM dishes";
    private static final String SELECT_ALL_INGREDIENTS = "SELECT * FROM dish_ingredients";
    private static final String INSERT_DISH = "INSERT INTO dishes VALUES(?, ?, ?)";
    private static final String INSERT_INGREDIENTS = "INSERT INTO dish_ingredients VALUES (?, ?)";
    private static final String DELETE = "DELETE FROM dishes where title = ?";
    private static final String GET_DISH_BY_ID = "SELECT * FROM dishes where title = ?";
    private static final String GET_INGREDIENTS_FOR_DISH = "SELECT product_title, product_weight from dish_ingredients where dish_title = ?";
    private static final String UPDATE = "UPDATE dishes SET recepylink = ?, calories_capacity = ? WHERE title = ?";

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

/*    public static Optional<Product> getEntityById(@NotNull String id) throws SQLException{
        var statement = connection.prepareStatement(GET_BY_ID);
        statement.setString(1, id);
        var resultSet = statement.executeQuery();
        Product product = null;
        if(!resultSet.isClosed()) product = new Product(
                resultSet.getString(1),
                resultSet.getInt(2));
        return Optional.ofNullable(product);
    }*/

    public static void delete(@NotNull String id) throws SQLException{
        var statement = connection.prepareStatement(DELETE);
        statement.setString(1, id);
        statement.execute();
    }

    public static void create(@NotNull Dish entity) throws SQLException{
        var dishstatement = connection.prepareStatement(INSERT_DISH);
        var productstatement = connection.prepareStatement(INSERT_INGREDIENTS);
        dishstatement.setString(1, entity.getTitle());
        dishstatement.setString(2, entity.getRecepyLink());
        dishstatement.setInt(3, entity.getCaloriesCapacity());
        dishstatement.execute();
        var ingredients = entity.getIngredients();
        for (Product prod: ingredients.keySet()) {
            productstatement.setString(2, prod.getTitle());
            productstatement.setString(1, entity.getTitle());
            productstatement.execute();
        }
    }

    private static HashMap<Product, Integer> getIngredients(@NotNull String title) throws SQLException{
        var statement = connection.prepareStatement(GET_INGREDIENTS_FOR_DISH);
        statement.setString(1, title);
        var resultSet = statement.executeQuery();
        var ingredients = new HashMap<Product, Integer>();
        Integer weight = 0;
        String curtitle;
        while (resultSet.next()){
            curtitle = resultSet.getString(1);
            weight = resultSet.getInt(2);
            ingredients.put(ProductDao.getEntityById(curtitle).get(), weight);
        }
        return ingredients;
    }

    public static List<Dish> getAll() {
        var result = new LinkedList<Dish>();
        try (var statement = connection.createStatement()) {
            var resultDishesSet = statement.executeQuery(SELECT_ALL_DISHES);
            while(resultDishesSet.next()){
                result.add(
                        new Dish(
                                resultDishesSet.getString("title"),
                                getIngredients(resultDishesSet.getString("title")),
                                resultDishesSet.getInt("calories_capacity"),
                                resultDishesSet.getString("recepylink")
                        )
                );
            }
            return result;
        }
        catch (SQLException e){
            logger.error("Failed to execute statement");
            logger.error(e);
        }
        return result;

    }
}

