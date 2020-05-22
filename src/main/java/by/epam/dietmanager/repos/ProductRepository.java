package by.epam.dietmanager.repos;

import by.epam.dietmanager.model.Dish;
import by.epam.dietmanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByTitleContainingIgnoreCase(String filter);
    Product findByTitle(String title);
}
