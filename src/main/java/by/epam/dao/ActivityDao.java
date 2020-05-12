package by.epam.dao;

import by.epam.collections.TrainingType;
import by.epam.entity.Activity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class ActivityDao extends Dao<Activity, Integer> {
    private static final String SELECT_ALL = "SELECT * FROM activity";
    private static final String INSERT_FULL = "INSERT INTO activity VALUES(NULL, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM activity where Id = ?";
    private static final String GET_BY_ID = "SELECT * FROM activity where Id = ?";
    private static final String UPDATE = "UPDATE activity SET Type = ?, Link = ?, Description = ? WHERE Id = ?";

    public void update(Activity entity) throws SQLException {
        var statement = getConnection().prepareStatement(UPDATE);
        statement.setString(1, entity.getType().toString());
        statement.setString(2, entity.getLink());
        statement.setString(3, entity.getDescription());
        statement.setInt(4, entity.getId());
        statement.execute();
    }

    public Optional<Activity> getEntityById(Integer id) throws SQLException{
        var statement = getConnection().prepareStatement(GET_BY_ID);
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

    public  void delete(Integer id) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement(DELETE);
        statement.setInt(1, id);
        statement.execute();
    }

    public  void create(Activity entity) throws SQLException{
        PreparedStatement statement = getConnection().prepareStatement(INSERT_FULL);
        statement.setString(1, entity.getType().toString());
        statement.setString(2, entity.getLink());
        statement.setString(3, entity.getDescription());
        statement.execute();
    }

    public ArrayList<Activity> getAll() throws SQLException{
        var result = new ArrayList<Activity>();
        var statement = getConnection().createStatement();
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
        return result;

    }
}
