package by.epam.dietmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.util.Map;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(Map<String, Object> model){
        return "index";
    }

    @GetMapping(value="/css/{cssFile}")
    public @ResponseBody byte[] getFile(@PathVariable("cssFile") String cssFile) {

        InputStream in = getClass()
                .getResourceAsStream("/css/" + cssFile);
        try {
            return in.readAllBytes();

        } catch (Exception e){
            var error = "ERROR: css file (/css/" + cssFile + ") not found";
            return error.getBytes();
        }
    }

    @GetMapping(value="/assets/{fileName}")
    public @ResponseBody byte[] getAssetFile(@PathVariable("fileName") String fileName) {

        InputStream in = getClass()
                .getResourceAsStream("/assets/" + fileName);
        try {
            return in.readAllBytes();

        } catch (Exception e){
            var error = "ERROR: asset file (/assets/" + fileName + ") not found";
            return error.getBytes();
        }
    }
}
