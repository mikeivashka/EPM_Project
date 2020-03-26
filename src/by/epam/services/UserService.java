package by.epam.services;

import by.epam.dao.UserDao;
import by.epam.entity.User;

import java.util.ArrayList;


public abstract class UserService extends Service<User, String, UserDao> {
    public boolean delete(String email){
        Integer index = getIndexByKey(email);
        if(index != -1){
            data.remove(index);
            return true;
        }
        else return false;
    }

    public ArrayList<User> getAll(){
        return data;
    }
}
