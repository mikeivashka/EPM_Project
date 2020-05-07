package by.epam.dao.db;

import by.epam.collections.ActivityLevel;
import by.epam.collections.Gender;
import by.epam.entity.Client;
import by.epam.entity.Nutritionist;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ClientDao extends Dao<Client, String>{
    private static final String SELECT_ALL = "SELECT * FROM clients";
    private static final String INSERT_FULL = "INSERT INTO clients VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM clients where email = ?";
    private static final String GET_BY_ID = "SELECT * FROM clients where email = ?";
    private static final String UPDATE = "UPDATE clients SET name = ?, surname = ?, age = ?,weight = ?, height = ?, activity_level = ?, gender = ?, nutritionist = ? WHERE email = ?";

    public static void update(@NotNull Client client) {
        try {
            var statement = connection.prepareStatement(UPDATE);
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setInt(3, client.getAge());
            statement.setDouble(4, client.getWeight());
            statement.setInt(5, client.getHeight());
            statement.setString(6, client.getActivityLevel().name());
            statement.setString(7, client.getGender().name());
            statement.setString(8, client.getNutritionist().getEmail());
            statement.execute();
        }
        catch (SQLException e){
            logger.error(e);
        }
    }

    public static Optional<Client> getEntityById(@NotNull String email) throws SQLException{
        var statement = connection.prepareStatement(GET_BY_ID);
        statement.setString(1, email);
        var resultSet = statement.executeQuery();
        Client client = null;
        if(!resultSet.isClosed()) client = new Client(
                resultSet.getString("email"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getInt("age"),
                Gender.valueOf(resultSet.getString("gender")),
                resultSet.getInt("height"),
                resultSet.getDouble("weight"),
                ActivityLevel.valueOf(resultSet.getString("activity_level")),
                NutritionistDao.getEntityById(resultSet.getString("nutritionist")).get()
        );
        return Optional.ofNullable(client);
    }

    public static void delete(@NotNull String id) throws SQLException{
        var statement = connection.prepareStatement(DELETE);
        statement.setString(1, id);
        statement.execute();
    }

    public static void create(@NotNull Client client) throws SQLException{
        var statement = connection.prepareStatement(INSERT_FULL);
        statement.setString(1, client.getEmail());
        statement.setString(2, client.getName());
        statement.setString(3, client.getSurname());
        statement.setDouble(4, client.getWeight());
        statement.setInt(5, client.getHeight());
        statement.setString(6, client.getActivityLevel().name());
        statement.setString(7, client.getGender().name());
        statement.setString(8, client.getNutritionist().getEmail());
        statement.setInt(9, client.getAge());
        statement.execute();
    }

    public static List<Client> getAll() {
        var result = new LinkedList<Client>();
        try (var statement = connection.createStatement()) {
            var resultSet = statement.executeQuery(SELECT_ALL);
            while(resultSet.next()){
                result.add(
                        new Client(
                                resultSet.getString("email"),
                                resultSet.getString("name"),
                                resultSet.getString("surname"),
                                resultSet.getInt("age"),
                                Gender.valueOf(resultSet.getString("gender")),
                                resultSet.getInt("height"),
                                resultSet.getDouble("weight"),
                                ActivityLevel.valueOf(resultSet.getString("activity_level")),
                                NutritionistDao.getEntityById(resultSet.getString("nutritionist")).get()
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
