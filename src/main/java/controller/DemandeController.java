package controller;

// import model.Demande;
import model.Commune;
import model.District;
import model.Personne;
import model.Region;
// import service.DemandeService;
import service.PersonneService;
import service.RegionService;
import repository.CommuneRepository;
import repository.DistrictRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.web.util.HtmlUtils;

// import javax.swing.plaf.synth.Region;

@Controller
@RequestMapping("/home")//Généraliser 
public class DemandeController {

    // @Autowired
    // private DemandeService demandeService;

    @Autowired
    private PersonneService personneService;
    @Autowired
    private RegionService regionService;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private CommuneRepository communeRepository;


    @PostMapping
    public String home(@RequestParam("username") String nom,Model model) {//ViewResolver no ampiasaina
      //  personneService = new PersonneService();Si on créer un nouvelle objet ici celà n'est pas géré par spring
        personneService.save(new Personne(nom));
        model.addAttribute("username", nom);

        ArrayList<Region> listRegion=regionService.getAllRegions();

        model.addAttribute("listRegion", listRegion);
        return "home";
    }

      @GetMapping(value = "/districts", produces = "text/html; charset=UTF-8")
      @ResponseBody
      public String districts(@RequestParam("regionId") int regionId) {
        List<District> districts = districtRepository.findByRegionId(regionId);

        StringBuilder html = new StringBuilder();
        html.append("<option value=\"\">-- Choisir un district --</option>");
        for (District district : districts) {
          html.append("<option value=\"")
            .append(district.getId())
            .append("\">")
            .append(HtmlUtils.htmlEscape(district.getNom()))
            .append("</option>");
        }
        return html.toString();
      }

      @GetMapping(value = "/communes", produces = "text/html; charset=UTF-8")
      @ResponseBody
      public String communes(@RequestParam("districtId") int districtId) {
        List<Commune> communes = communeRepository.findByDistrictId(districtId);

        StringBuilder html = new StringBuilder();
        html.append("<option value=\"\">-- Choisir une commune --</option>");
        for (Commune commune : communes) {
          html.append("<option value=\"")
            .append(commune.getId())
            .append("\">")
            .append(HtmlUtils.htmlEscape(commune.getNom()))
            .append("</option>");
        }
        return html.toString();
      }

    // @GetMapping("/demande")
    // public String demande(){
    //     Date date=
    // }
}