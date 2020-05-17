package by.epam.dietmanager.controller;
import by.epam.dietmanager.collections.TrainingType;
import by.epam.dietmanager.model.Activity;
import by.epam.dietmanager.repos.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("management/activities")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping
    public String activity(@RequestParam(name = "filter", required = false)String filter, Map<String, Object> model){
        Iterable<Activity> activities =
                (filter == null ? activityRepository.findAll() :
                        activityRepository.findByType(TrainingType.valueOf(filter)) );
        model.put("activities", activities);
        return "activities";
    }

    @PostMapping
    public String add(
            @RequestParam(name = "type") String type,
            @RequestParam(name = "link") String link,
            @RequestParam(name = "description")String description,
            Map<String, Object> model
            ){
        Activity activity = new Activity(TrainingType.valueOf(type), description, link);
        activityRepository.save(activity);
        Iterable<Activity> activities = activityRepository.findAll();
        model.put("activities", activities);
        return "activities";
    }

//    @PostMapping("filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model){
//        Iterable<Activity> activities = activityRepository.findAll();
//        List<Activity> filtered = activityRepository.findByType(TrainingType.valueOf(filter));
//        model.put("activities", filtered);
//        return "activities";
//    }

}
