package by.epam.dietmanager.controller;

import by.epam.dietmanager.model.AbstractUser;
import by.epam.dietmanager.model.Client;
import by.epam.dietmanager.model.Nutritionist;
import by.epam.dietmanager.repos.ClientRepository;
import by.epam.dietmanager.repos.NutritionistRepository;
import by.epam.dietmanager.repos.RecommendationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAnyAuthority('CLIENT')")
public class ClientController {
    private Logger logger = LogManager.getLogger();

    @Autowired
    ClientRepository clientRepo;

    @Autowired
    NutritionistRepository nutrRepo;

    @Autowired
    RecommendationRepository recomRepo;

    @GetMapping("program")
    public String getProgram(@AuthenticationPrincipal AbstractUser sender, Map<String, Object> model) {
        Client client = clientRepo.getOne(sender.getId());
        Nutritionist nutritionist = client.getNutritionist();
        if (nutritionist == null) {
            return "redirect:program/start";
        }
        model.put("recommendations", recomRepo.findByReceiverIdAndAuthorId(client.getId(), client.getNutritionist().getId()));
        model.put("nutr", nutritionist);
        return "program";
    }

    @PostMapping("program/unsubscribe")
    public String unsubscribe(@AuthenticationPrincipal AbstractUser user) {
        Client client = clientRepo.getOne(user.getId());
        client.setNutritionist(null);
        clientRepo.save(client);
        return "redirect:/user/program";
    }

    @GetMapping("program/start")
    public String startProgram(Map<String, Object> model) {
        model.put("nutritionists", nutrRepo.findAll());
        return "quickstart";
    }

    @PostMapping("program/save")
    public String saveNutr(@RequestParam Integer nutrId, @AuthenticationPrincipal AbstractUser user) {
        Client client = clientRepo.getOne(user.getId());
        client.setNutritionist(nutrRepo.getOne(nutrId));
        clientRepo.save(client);
        logger.info("User with id " + client.getId() + "now works with nutr(id):" + nutrId);
        return "redirect:/user/program";
    }
}
