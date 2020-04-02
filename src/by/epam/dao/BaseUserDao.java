package by.epam.dao;

import by.epam.entity.BaseUser;

public class BaseUserDao extends Dao<BaseUser> {
    private static final String dir = "data/BaseUser.dat";

    @Override
    public String getDir() {
        return dir;
    }
}
