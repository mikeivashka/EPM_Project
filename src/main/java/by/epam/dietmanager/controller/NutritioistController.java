package by.epam.dietmanager.controller;

import by.epam.dietmanager.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nutr")
@PreAuthorize("hasAnyAuthority('NUTRITIONIST')")
public class NutritioistController {
    @Autowired
    ClientRepository clientRepo;
}
