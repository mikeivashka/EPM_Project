package by.epam.dietmanager.controller;

import by.epam.dietmanager.collections.ActivityLevel;
import by.epam.dietmanager.collections.Gender;
import by.epam.dietmanager.model.AbstractUser;
import by.epam.dietmanager.model.Client;
import by.epam.dietmanager.model.Nutritionist;
import by.epam.dietmanager.repos.ClientRepository;
import by.epam.dietmanager.repos.NutritionistRepository;
import org.apache.logging.log4j.Logger;
import org.dom4j.rule.Mode;
import org.hibernate.annotations.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class AccountController {
    @Autowired
    ClientRepository repository;

    @Autowired
    NutritionistRepository nutrRepository;


    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String userList(Model model){
        List<AbstractUser> userList = new LinkedList<>();
        userList.addAll(repository.findAll());
        userList.addAll(nutrRepository.findAll());
        model.addAttribute("users", userList);
        return "user_list";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public String changeActiveStatus(@RequestParam String id, @RequestParam (required = false)String active, @RequestParam String role){
        Integer uid = Integer.valueOf(id);
        if (role.equals("CLIENT")){
            Client client = repository.getOne(uid);
            client.setActive(active == null ? false : true);
            repository.save(client);
        }
        else {
            Nutritionist nutritionist = nutrRepository.getOne(uid);
            nutritionist.setActive(active != null);
            nutrRepository.save(nutritionist);
        }
        return "redirect:/user";
    }

    @PreAuthorize("hasAnyAuthority('CLIENT')")
    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal Client client){
        model.addAttribute("user", repository.getOne(client.getId()));
        return "client_profile";
    }

    @PostMapping("profile")
    public String save(@RequestParam("id") Client client,
                       @RequestParam("email") String email,
                       @RequestParam("password") String password,
                       @RequestParam("name") String name,
                       @RequestParam("surname") String surname,
                       @RequestParam("age") Integer age,
                       @RequestParam("gender") String gender,
                       @RequestParam("activity") String activity,
                       @RequestParam("weight") Double weight,
                       @RequestParam("height") Integer height,
                       Map<String, Object> model
                       ){
        client.setActivityLevel(ActivityLevel.valueOf(activity));
        client.setPassword(password);
        client.setAge(age);
        client.setSurname(surname);
        client.setName(name);
        client.setGender(Gender.valueOf(gender));
        client.setWeight(weight);
        client.setHeight(height);
        if(( repository.findByEmail(email) != null || nutrRepository.findByEmail(email)!=null) && !email.equals(client.getEmail())){
            model.put("message", "Данный e-mail уже занят, изменения не сохранены");
            model.put("user", client);
            return "client_profile";
        }
        else {
            client.setEmail(email);
        }
        repository.save(client);
        return "redirect:profile";
    }

//    @PreAuthorize("hasAnyAuthority('NUTRITIONIST')")
//    @GetMapping("profile")
//    public String getProfile(Model model, @AuthenticationPrincipal Nutritionist nutr){
//        model.addAttribute("user", nutr);
//        return "client_profile";
//    }
}
