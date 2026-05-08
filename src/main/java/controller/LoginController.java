package controller;

import service.DemandeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String home() {//ViewResolver no ampiasaina
        return "login";
    }
    
}
