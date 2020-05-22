package by.epam.dietmanager.controller;

import by.epam.dietmanager.collections.TrainingType;
import by.epam.dietmanager.model.Activity;
import by.epam.dietmanager.model.Dish;
import by.epam.dietmanager.model.Product;
import by.epam.dietmanager.repos.DishRepository;
import by.epam.dietmanager.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RequestMapping("/dishes")
@PreAuthorize("hasAnyAuthority('ADMIN', 'NUTRITIONIST')")
@Controller
public class DishController {
    @Autowired
    DishRepository dishRepo;
    @Autowired
    ProductRepository prodRepo;

    @PostMapping("/add/dish")
    public String addDish(
            @RequestParam(value = "prod_id[]") List<String> prod_id,
            @RequestParam(name = "title")String title,
            @RequestParam String link,
            @RequestParam (name="calories")Integer calories){
        return "";
    }

    @GetMapping("add/product")
    public  String getProdPage(){
        return "add_prod";
    }

    @PostMapping("add/product")
    public String addProd(
            @RequestParam String title,
            @RequestParam Integer calories,
            Map<String, Object> model
            ){
        String successMsg = "Блюдо успешно добавлено";
        String failureMsg = "Данное название уже занято, блюдо не создано";
        if(prodRepo.findByTitle(title) == null){
            Product product = new Product();
            product.setCaloriesCapacity(calories);
            product.setTitle(title);
            prodRepo.save(product);
            model.put("success", successMsg);
        }
        else{
            model.put("failure", failureMsg);
        }
        return "add_prod";
    }

    @GetMapping
    public String dishes(
            @RequestParam(required = false, defaultValue = "") String dish_name_filter,
            @RequestParam(required = false, defaultValue = "0") Integer minCalories,
            @RequestParam(required = false, defaultValue = "10000") Integer maxCalories,
            @RequestParam(required = false, defaultValue = "") String prod_filter,
            Map<String, Object> model
    ) {
        Iterable<Dish> dishes = dishRepo.findByTitleContainingIgnoreCaseAndCaloriesCapacityBetween(dish_name_filter, minCalories, maxCalories);
        Iterable<Product> products = prodRepo.findByTitleContainingIgnoreCase(prod_filter);
        model.put("prod_filter",prod_filter);
        model.put("products", products);
        model.put("dishes", dishes);
        return "dishes";
    }
}
