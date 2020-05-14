package by.epam.dietmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(Map<String, Object> model){
        return "index";
    }
}
