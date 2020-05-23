package by.epam.dietmanager.controller;

import by.epam.dietmanager.collections.ActivityLevel;
import by.epam.dietmanager.collections.Gender;
import by.epam.dietmanager.collections.Role;
import by.epam.dietmanager.model.AbstractUser;
import by.epam.dietmanager.model.Client;
import by.epam.dietmanager.model.Nutritionist;
import by.epam.dietmanager.repos.ClientRepository;
import by.epam.dietmanager.repos.NutritionistRepository;
import by.epam.dietmanager.services.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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
    private static Logger logger = LogManager.getLogger();
    @Autowired
    private UserService userService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private NutritionistRepository nutrRepository;


    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String userList(Model model) {
        List<AbstractUser> userList = new LinkedList<>();
        userList.addAll(clientRepository.findAll());
        userList.addAll(nutrRepository.findAll());
        model.addAttribute("users", userList);
        return "user_list";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public String changeActiveStatus(@RequestParam String id, @RequestParam(required = false) String active, @RequestParam String role) {
        Integer uid = Integer.valueOf(id);
        if (role.equals(Role.CLIENT.name())) {
            Client client = clientRepository.getOne(uid);
            client.setActive(active != null);
            clientRepository.save(client);
        } else {
            Nutritionist nutritionist = nutrRepository.getOne(uid);
            nutritionist.setActive(active != null);
            nutrRepository.save(nutritionist);
        }
        return "redirect:/user";
    }

    @PreAuthorize("hasAnyAuthority('CLIENT', 'NUTRITIONIST')")
    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal AbstractUser user) {
        if (user instanceof Client) {
            model.addAttribute("user", clientRepository.getOne(user.getId()));
            return "client_profile";
        } else {
            model.addAttribute("user", nutrRepository.getOne(user.getId()));
            return "nutr_profile";
        }
    }


    @PostMapping("profile")
    @PreAuthorize("hasAnyAuthority('CLIENT', 'NUTRITIONIST')")
    public String save(@RequestParam("id") Integer id,
                       @RequestParam("email") String email,
                       @RequestParam("password") String password,
                       @RequestParam("name") String name,
                       @RequestParam("surname") String surname,
                       @RequestParam(name = "age", required = false) Integer age,
                       @RequestParam(name = "gender", required = false) String gender,
                       @RequestParam(name = "activity", required = false) String activity,
                       @RequestParam(name = "weight", required = false) Double weight,
                       @RequestParam(name = "height", required = false) Integer height,
                       Map<String, Object> model
    ) {
        AbstractUser user;
        if(clientRepository.findById(id).isPresent()){
            user = clientRepository.getOne(id);
        }
        else {
            user = nutrRepository.getOne(id);
        }
        String failureMsg = "Данный e-mail уже занят, изменения не сохранены";
        boolean success = true;
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        if (userService.validateForEmailDuplicates(email, id)) {
            user.setEmail(email);
        } else
            success = false;
        if (user.getRole() == Role.CLIENT) {
            Client client = (Client) user;
            client.setActivityLevel(ActivityLevel.valueOf(activity));
            client.setAge(age);
            client.setGender(Gender.valueOf(gender));
            client.setWeight(weight);
            client.setHeight(height);
            if (success) {
                clientRepository.save(client);
            }
        } else if (success) {
            nutrRepository.save((Nutritionist) user);
        }
        model.put("user", user);
        if (success) {
            logger.info("User successfully updated:" + user);
            return "redirect:profile";
        }
        else {
            model.put("message", failureMsg);
            if(user.getRole() == Role.CLIENT){
                return "client_profile";
            }
            else {
                return "nutr_profile";
            }
        }

    }
}
