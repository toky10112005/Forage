package controller;

import service.DemandeService;
import service.PersonneService;
import service.RegionService;

import model.Region;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.Personne;

@Controller
@SessionAttributes("userID")
public class LoginController {
    @Autowired
    private PersonneService personneService;

    @Autowired
    private RegionService regionService;


    @GetMapping("/")
    public String home() {//ViewResolver no ampiasaina
        return "login";
    }

    @PostMapping("/home")
     public String home(@RequestParam("username") String nom,Model model) {//ViewResolver no ampiasaina
      //  personneService = new PersonneService();Si on créer un nouvelle objet ici celà n'est pas géré par spring
        Personne personne = personneService.getPersonneByName(nom);
        
        if(personne == null){
            personne = personneService.save(new Personne(nom));
        }

        model.addAttribute("username", nom);
        model.addAttribute("userID", personne.getId());

        ArrayList<Region> listRegion=regionService.getAllRegions();
        model.addAttribute("listRegion", listRegion);
        // return "home";
        return "choix";
    }
    
}
