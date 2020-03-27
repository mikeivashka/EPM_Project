package by.epam.dao;

import by.epam.entity.Product;

public class ProductDao extends Dao<Product> {
    private static final String dir = "data/product.dat";

    @Override
    public String getDir() {
        return dir;
    }
}
