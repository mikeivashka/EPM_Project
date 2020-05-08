package by.epam.dao;

import by.epam.collections.ActivityLevel;
import by.epam.collections.Gender;
import by.epam.entity.Client;
import by.epam.entity.Nutritionist;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class ClientDao extends Dao<Client, String>{
    private static final String SELECT_ALL = "SELECT * FROM clients";
    private static final String SELECT_CLIENTS_FOR_NUTRITIONIST = "SELECT email, name, surname, weight, height, activity_level, age, nutritionist, gender FROM clients WHERE nutritionist = ?";
    private static final String INSERT_FULL = "INSERT INTO clients VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM clients where email = ?";
    private static final String GET_BY_ID = "SELECT * FROM clients where email = ?";
    private static final String UPDATE = "UPDATE clients SET name = ?, surname = ?, age = ?,weight = ?, height = ?, activity_level = ?, gender = ?, nutritionist = ? WHERE email = ?";

    public void update(@NotNull Client client) throws SQLException {
        var statement = getConnection().prepareStatement(UPDATE);
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

    private Client getClient(ResultSet set) throws SQLException{
        return new Client(
                set.getString("email"),
                set.getString("name"),
                set.getString("surname"),
                set.getInt("age"),
                Gender.valueOf(set.getString("gender")),
                set.getInt("height"),
                set.getDouble("weight"),
                ActivityLevel.valueOf(set.getString("activity_level")),
                new NutritionistDao().getEntityById(set.getString("nutritionist")).get()
        );
    }

    public ArrayList<Client> getClientsForNutritionist(Nutritionist ob) throws SQLException{
        var statement = getConnection().prepareStatement(SELECT_CLIENTS_FOR_NUTRITIONIST);
        statement.setString(1, ob.getEmail());
        var resultSet = statement.executeQuery();
        var result = new ArrayList<Client>();
        while(resultSet.next()){
            result.add(
                    getClient(resultSet)
            );
        }
        return result;
    }

    public Optional<Client> getEntityById(@NotNull String email) throws SQLException{
        var statement = getConnection().prepareStatement(GET_BY_ID);
        statement.setString(1, email);
        var resultSet = statement.executeQuery();
        Client client = null;
        if(!resultSet.isClosed()) client = getClient(resultSet);
        return Optional.ofNullable(client);
    }

    public void delete(@NotNull String id) throws SQLException{
        var statement = getConnection().prepareStatement(DELETE);
        statement.setString(1, id);
        statement.execute();
    }

    public void create(@NotNull Client client) throws SQLException{
        var statement = getConnection().prepareStatement(INSERT_FULL);
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

    public ArrayList<Client> getAll() throws SQLException{
        var result = new ArrayList<Client>();
        var statement = getConnection().createStatement();
        var resultSet = statement.executeQuery(SELECT_ALL);
        while(resultSet.next()){
            result.add(
                    getClient(resultSet)
            );
        }
        return result;

    }
}
