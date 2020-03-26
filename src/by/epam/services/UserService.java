package by.epam.services;

import by.epam.dao.UserDao;
import by.epam.entity.User;

import java.util.ArrayList;


public abstract class UserService extends Service<User, String, UserDao> {
    public boolean delete(String email){
        return dao.delete(email);
    }

    public ArrayList<User> getAll(){
        return dao.getAll();
    }
}
