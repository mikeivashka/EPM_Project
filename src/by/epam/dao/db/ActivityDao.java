package by.epam.dao.db;

import by.epam.collections.TrainingType;
import by.epam.entity.Activity;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ActivityDao extends Dao<Activity, Integer> {
    private static final String SELECT_ALL = "SELECT * FROM activity";
    private static final String INSERT_FULL = "INSERT INTO activity VALUES(NULL, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM activity where Id = ?";
    private static final String GET_BY_ID = "SELECT * FROM activity where Id = ?";
    private static final String UPDATE = "UPDATE activity SET Type = ?, Link = ?, Description = ? WHERE Id = ?";

    public static void update(Activity entity) {
        try {
            var statement = connection.prepareStatement(UPDATE);
            statement.setString(1, entity.getType().toString());
            statement.setString(2, entity.getLink());
            statement.setString(3, entity.getDescription());
            statement.setInt(4, entity.getId());
            statement.execute();
        }
        catch (SQLException e){
            logger.error(e);
        }
    }

    public static Optional<Activity> getEntityById(Integer id) throws SQLException{
        var statement = connection.prepareStatement(GET_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Activity activity = null;
        if(!resultSet.isClosed()) activity = new Activity(
                resultSet.getInt("Id"),
                TrainingType.valueOf(resultSet.getString("Type")),
                resultSet.getString("Description"),
                resultSet.getString("Link")
        );
        return Optional.ofNullable(activity);
    }

    public static void delete(Integer id) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(DELETE);
        statement.setInt(1, id);
        statement.execute();
    }

    public static void create(Activity entity) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(INSERT_FULL);
        statement.setString(1, entity.getType().toString());
        statement.setString(2, entity.getLink());
        statement.setString(3, entity.getDescription());
        statement.execute();
    }

    public static List<Activity> getAll() {
        var result = new LinkedList<Activity>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while(resultSet.next()){
                result.add(
                        new Activity(
                                resultSet.getInt("Id"),
                                TrainingType.valueOf(resultSet.getString("Type")),
                                resultSet.getString("Description"),
                                resultSet.getString("Link")
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
