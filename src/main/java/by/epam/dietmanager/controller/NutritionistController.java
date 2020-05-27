package by.epam.dietmanager.controller;

import by.epam.dietmanager.model.AbstractUser;
import by.epam.dietmanager.model.Dish;
import by.epam.dietmanager.model.Nutritionist;
import by.epam.dietmanager.model.Recommendation;
import by.epam.dietmanager.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/nutr")
@PreAuthorize("hasAnyAuthority('NUTRITIONIST')")
public class NutritionistController {
    @Autowired
    ClientRepository clientRepo;

    @Autowired
    NutritionistRepository nutrRepo;

    @Autowired
    DishRepository dishRepo;

    @Autowired
    ActivityRepository activityRepo;

    @Autowired
    RecommendationRepository recomRepo;

    @PostMapping("recommendations/new")
    public String sendRecommendation(@RequestParam(name = "dishesId[]") List<Integer> dishesId,
                                     @RequestParam Integer activity,
                                     @RequestParam Integer clientId,
                                     @AuthenticationPrincipal AbstractUser user,
                                     @RequestParam String comment,
                                     Map<String, Integer> model
                                ){
        Recommendation recommendation = new Recommendation();
        Set<Dish> dishes = new HashSet<>();
        for (Integer dishId: dishesId) {
            dishes.add(dishRepo.getOne(dishId));
        }
        recommendation.setReceiver(clientRepo.getOne(clientId));
        recommendation.setActivityId(activity);
        recommendation.setAuthor((Nutritionist) user);
        recommendation.setText(comment);
        recommendation.setDishes(dishes);
        recomRepo.save(recommendation);
        System.out.println(recomRepo.getOne(recommendation.getId()));
        return "redirect:new/success";
    }

    @GetMapping("recommendations/new/success")
    public String successMsg(){
        return "add_recommendation_success";
    }

    @GetMapping("recommendations/new")
    public String createRecommendation(@RequestParam Integer clientId,
                                       @AuthenticationPrincipal AbstractUser user,
                                       Map<String, Object> model
                    ){
        model.put("client", clientRepo.getOne(clientId));
        model.put("dishes", dishRepo.findAll());
        model.put("activities", activityRepo.findAll());
        return "add_recommendation";
    }

    @GetMapping("clients")
    public String getClients(@AuthenticationPrincipal AbstractUser user, Map<String, Object> model){
        Nutritionist nutr = nutrRepo.getOne(user.getId());
        model.put("clients", nutr.getClients());
        return "clients";
    }

}
