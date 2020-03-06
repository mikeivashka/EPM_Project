package by.epam.dao;

import by.epam.entity.User;

public class UserController extends Controller<User, String> {
    private static final String dir = "data/user.dat";
    public UserController() {
        super.initialize(dir);
    }
}
