package by.epam.dietmanager.repos;

import by.epam.dietmanager.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {
    List<Dish> findByTitleContainingIgnoreCaseAndCaloriesCapacityBetween(String filter, Integer min, Integer max);
    Dish findByTitle(String title);
}
