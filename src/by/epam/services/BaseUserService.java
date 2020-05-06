package by.epam.services;

import by.epam.dao.deprecated.BaseUserDao;
import by.epam.entity.Client;

public class BaseUserService extends Service<Client, String, BaseUserDao> {
    public BaseUserService() {
        super.dao = new BaseUserDao();
        super.data = dao.load();
    }
}
