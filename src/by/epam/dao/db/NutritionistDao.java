package by.epam.dao.db;

import by.epam.entity.Nutritionist;
import by.epam.entity.Product;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class NutritionistDao extends Dao<Nutritionist, String>{
    private static final String SELECT_ALL = "SELECT * FROM nutritionists";
    private static final String INSERT_FULL = "INSERT INTO nutritionists VALUES(?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM nutritionists where email = ?";
    private static final String GET_BY_ID = "SELECT * FROM nutritionists where email = ?";
    private static final String UPDATE = "UPDATE nutritionists SET experience = ?, rating = ?, name = ?, surname = ? WHERE email = ?";

    public static void update(@NotNull Nutritionist nutritionist) {
        try {
            var statement = connection.prepareStatement(UPDATE);
            statement.setInt(1, nutritionist.getExperience());
            statement.setDouble(2, nutritionist.getRating());
            statement.setString(3, nutritionist.getName());
            statement.setString(4, nutritionist.getSurname());
            statement.execute();
        }
        catch (SQLException e){
            logger.error(e);
        }
    }

    public static Optional<Nutritionist> getEntityById(@NotNull String email) throws SQLException{
        var statement = connection.prepareStatement(GET_BY_ID);
        statement.setString(1, email);
        var resultSet = statement.executeQuery();
        Nutritionist nutritionist = null;
        if(!resultSet.isClosed()) nutritionist = new Nutritionist(
                resultSet.getString(1),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getInt("experience"),
                resultSet.getDouble("rating")
        );
        return Optional.ofNullable(nutritionist);
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
