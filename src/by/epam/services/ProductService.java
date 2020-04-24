package by.epam.services;

import by.epam.dao.deprecated.ProductDao;
import by.epam.entity.Product;


public class ProductService extends Service<Product, String, ProductDao>{
    public ProductService() {
        super.dao = new ProductDao();
        super.data = dao.load();
    }
}
