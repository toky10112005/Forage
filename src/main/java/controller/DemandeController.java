package controller;

import model.Demande;
import service.DemandeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Date;

@Controller
public class DemandeController {

    private DemandeService demandeService;

    @GetMapping("/")
    public String home() {
        // Retourne le nom du fichier JSP sans l'extension (grâce au ViewResolver)
        return "home";
    }

    @GetMapping("/demande")
    public String demande(){
        Date date=
    }
}