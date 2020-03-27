package by.epam.dao;

import by.epam.entity.User;

public class UserDao extends Dao<User> {
    private static final String dir = "data/user.dat";

    @Override
    public String getDir() {
        return dir;
    }
}
