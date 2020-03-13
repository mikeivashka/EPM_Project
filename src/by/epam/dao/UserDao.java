package by.epam.dao;

import by.epam.entity.User;

public class UserDao extends Dao<User, String> {
    private static final String dir = "data/user.dat";

    @Override
    public String getDir() {
        return dir;
    }
}
