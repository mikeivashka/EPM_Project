package by.epam.services;

import by.epam.dao.DishDao;
import by.epam.entity.Activity;
import by.epam.entity.Dish;
import by.epam.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DishService extends Service<Dish, String, DishDao>{


    public DishService() {
        super.dao = new DishDao();
        super.data = dao.load();
    }
}
