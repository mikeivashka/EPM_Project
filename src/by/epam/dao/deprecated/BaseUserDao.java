package by.epam.dao.deprecated;

import by.epam.entity.Client;

public class BaseUserDao extends Dao<Client> {
    private static final String dir = "data/BaseUser.dat";

    @Override
    public String getDir() {
        return dir;
    }
}
