package by.epam.dietmanager.services;

import by.epam.dietmanager.model.Dish;
import by.epam.dietmanager.model.Product;
import by.epam.dietmanager.repos.DishRepository;
import by.epam.dietmanager.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class DishService {
    @Autowired
    DishRepository dishRepo;

    @Autowired
    ProductRepository prodRepo;

    public Map<String, Object> addDish(Map<String, Object> model, List<Integer> productsId, String title, String link, Integer calories) {
        String errorMsg = "Блюдо с таким названием уже существует, изменения не сохранены";
        String successMsg = "Блюдо успешно создано";
        Dish dish;
        model.put("products", prodRepo.findAll());
        dish = dishRepo.findByTitle(title);
        if(dish == null){
            dish = new Dish();
            Set<Product> ingredients = new HashSet<Product>();
            dish.setCaloriesCapacity(calories);
            for (Integer id : productsId) {
                ingredients.add(prodRepo.getOne(id));
            }
            dish.setIngredients(ingredients);
            dish.setRecepyLink(link);
            dish.setTitle(title);
            dishRepo.save(dish);
            model.put("success", successMsg);
        }
        else model.put("failure", errorMsg);
        return model;

    }
}
