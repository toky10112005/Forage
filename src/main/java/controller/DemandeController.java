package controller;

import model.Demande;
import model.Personne;
import service.DemandeService;
import service.PersonneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model; 

import java.util.Date;

@Controller
@RequestMapping("/home")//Généraliser 
public class DemandeController {

    @Autowired
    private DemandeService demandeService;
    @Autowired
    private PersonneService personneService;


    @PostMapping
    public String home(@RequestParam("username") String nom,Model model) {//ViewResolver no ampiasaina
      //  personneService = new PersonneService();Si on créer un nouvelle objet ici celà n'est pas géré par spring
        personneService.save(new Personne(nom));
        model.addAttribute("username", nom);
        return "home";
    }

    // @GetMapping("/demande")
    // public String demande(){
    //     Date date=
    // }
}