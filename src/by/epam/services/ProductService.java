package by.epam.services;

import by.epam.collections.TrainingType;
import by.epam.dao.ProductDao;
import by.epam.entity.Activity;
import by.epam.entity.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ProductService extends Service<Product, String, ProductDao>{
    static Logger logger = LogManager.getLogger();

    public ProductService() {
        super.dao = new ProductDao();
        super.data = dao.load();
    }
}
