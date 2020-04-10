package by.epam.services;

import by.epam.dao.BaseUserDao;
import by.epam.entity.BaseUser;

public class BaseUserService extends Service<BaseUser, String, BaseUserDao> {
    public BaseUserService() {
        super.dao = new BaseUserDao();
        super.data = dao.load();
    }
}
