package by.epam.dao.db;

import by.epam.entity.Dish;
import by.epam.entity.Product;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.*;

public class DishDao extends Dao<Dish, String> {
    private static final String SELECT_ALL_DISHES = "SELECT * FROM dishes";
    private static final String SELECT_ALL_INGREDIENTS = "SELECT * FROM dish_ingredients";
    private static final String INSERT_DISH = "INSERT INTO dishes VALUES(?, ?, ?)";
    private static final String INSERT_INGREDIENTS = "INSERT INTO dish_ingredients VALUES (?, ?)";
    private static final String DELETE = "DELETE FROM dishes where title = ?";
    private static final String GET_DISH_BY_ID = "SELECT * FROM dishes where title = ?";
    private static final String GET_INGREDIENTS_FOR_DISH = "SELECT product_title, product_weight from dish_ingredients where dish_title = ?";
    private static final String UPDATE = "UPDATE dishes SET recepylink = ?, calories_capacity = ? WHERE title = ?";
    private static final String DELETE_INGREDIENTS = "DELETE FROM dish_ingredients WHERE dish_title = ?";

    public static void update(@NotNull Dish dish) {
        try {
            var statement = connection.prepareStatement(UPDATE);
            statement.setString(1, dish.getRecepyLink());
            statement.setInt(2, dish.getCaloriesCapacity());
            statement.setString(3, dish.getTitle());
            statement.execute();
            deleteIngredients(dish.getTitle());
            insertIngredients(dish.getTitle(), dish.getIngredients());
        }
        catch (SQLException e){
            logger.error(e);
        }
    }

    private static void insertIngredients(String dish_title, Map<Product, Integer> map) throws SQLException{
        var productstatement = connection.prepareStatement(INSERT_INGREDIENTS);
        for (Product prod: map.keySet()) {
            productstatement.setString(2, prod.getTitle());
            productstatement.setString(1, dish_title);
            productstatement.execute();
        }
    }

    public static Optional<Dish> getEntityById(@NotNull String id) throws SQLException{
        var statement = connection.prepareStatement(GET_DISH_BY_ID);
        statement.setString(1, id);
        var resultSet = statement.executeQuery();
        Dish dish = null;
        if(!resultSet.isClosed()) {
            dish = new Dish(
                    id,
                    getIngredients(id),
                    resultSet.getInt("calories_capacity"),
                    resultSet.getString("recepylink")
            );
        }
        return Optional.ofNullable(dish);
    }

    private static void deleteIngredients(String dish_title) throws SQLException{
        var statement = connection.prepareStatement(DELETE_INGREDIENTS);
        statement.setString(1, dish_title);
        statement.execute();
    }

    public static void delete(@NotNull String id) throws SQLException{
        var statement = connection.prepareStatement(DELETE);
        statement.setString(1, id);
        statement.execute();
    }

    public static void create(@NotNull Dish entity) throws SQLException{
        var dishstatement = connection.prepareStatement(INSERT_DISH);

        dishstatement.setString(1, entity.getTitle());
        dishstatement.setString(2, entity.getRecepyLink());
        dishstatement.setInt(3, entity.getCaloriesCapacity());
        dishstatement.execute();
        var ingredients = entity.getIngredients();
        insertIngredients(entity.getTitle(), entity.getIngredients());

    }

    private static HashMap<Product, Integer> getIngredients(@NotNull String title) throws SQLException{
        var statement = connection.prepareStatement(GET_INGREDIENTS_FOR_DISH);
        statement.setString(1, title);
        var resultSet = statement.executeQuery();
        var ingredients = new HashMap<Product, Integer>();
        int weight;
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
        }
        catch (SQLException e){
            logger.error("Failed to execute statement");
            logger.error(e);
        }
        return result;

    }
}

