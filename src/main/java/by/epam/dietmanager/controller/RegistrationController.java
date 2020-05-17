package by.epam.dietmanager.controller;

import by.epam.dietmanager.collections.Role;
import by.epam.dietmanager.model.AbstractUser;
import by.epam.dietmanager.model.Client;
import by.epam.dietmanager.model.Nutritionist;
import by.epam.dietmanager.repos.ClientRepository;
import by.epam.dietmanager.repos.NutritionistRepository;
import by.epam.dietmanager.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    ClientRepository clientRepo;
    @Autowired
    NutritionistRepository nutritionistRepo;

    @GetMapping("nutr/registration")
    public String nutrRegistration(){ return "nutr_registration"; }

    @PostMapping("nutr/registration")
    public String addNutr(Nutritionist nutritionist, Map<String, Object> model){
        if(clientRepo.findByEmail(nutritionist.getEmail()) == null && nutritionistRepo.findByEmail(nutritionist.getEmail()) == null && RegistrationService.isValidEmailAddress(nutritionist.getEmail())){
            nutritionist.setRating(8.0);
            nutritionist.setRole(Role.NUTRITIONIST);
            nutritionist.setActive(true);
            nutritionistRepo.save(nutritionist);
            return "redirect:/";
        }
        else if(!RegistrationService.isValidEmailAddress(nutritionist.getEmail())){
            model.put("message", "Введен невалидный e-mail. Проверьте правильность введенных данных");
        }
        else
            model.put("message", "Аккаунт с таким электронным адресом уже зарегистрирован");
        return "nutr_registration";
    }

    @GetMapping("/registration")
    public String registration(){
        return "user_registration";
    }

    @PostMapping("/registration" )
    public String addUser(Client client, Map<String, Object> model){
        if(clientRepo.findByEmail(client.getEmail()) == null && clientRepo.findByEmail(client.getEmail()) == null && RegistrationService.isValidEmailAddress(client.getEmail())){
            client.setRole(Role.CLIENT);
            client.setActive(true);
            clientRepo.save(client);
            return "redirect:/login";
        }
        else if(!RegistrationService.isValidEmailAddress(client.getEmail())){
            model.put("message", "Введен невалидный e-mail. Проверьте правильность введенных данных");
        }
        else {
            model.put("message","Этот адрес электронной почты уже используется!");
        }
        return "user_registration";
    }



}
