package controller;

// import model.Demande;
import model.Commune;
import model.District;
import model.Demande;
import service.LieuForageService;
import service.DemandeService;
import repository.CommuneRepository;
import repository.DistrictRepository;
import repository.DemandeStatusRepository;
import service.DemandeStatusService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.web.util.HtmlUtils;

// import javax.swing.plaf.synth.Region;

@Controller
//@SessionAttributes("userID")
@RequestMapping("/home")
public class DemandeController {

    // @Autowired
    // private DemandeService demandeService;

    @Autowired
    private LieuForageService lieuForageService;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private CommuneRepository communeRepository;

    @Autowired
    private DemandeService demandeService;

    @Autowired
    private DemandeStatusService demandeStatusService;
   
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

    @GetMapping("/demande")
    public String demande(@SessionAttribute("userID") int userID,
            @RequestParam(value = "dateDemande", required = false) String dateDemande,
            @RequestParam(value = "Region", required = false) String region, 
            @RequestParam(value = "District", required = false) String district, 
            @RequestParam(value = "Commune", required = false) String commune, 
            @RequestParam(value = "lieu", required = false) String lieu,
            @RequestParam(value = "Personne", required = false) String personne,
            Model model) {
        
        model.addAttribute("region", region);
        model.addAttribute("district", district);
        model.addAttribute("commune", commune);
        model.addAttribute("lieu", lieu);

        try {
            lieuForageService.save(region, district, commune);
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(dateDemande);

            Demande demande = demandeService.save(userID, date, lieu, personne, region);
            
            if (demande != null) {
                demandeStatusService.save(demande.getId(), 1, date);
            }

            // Récupérer toutes les demandes avec leurs statuts
            ArrayList<model.DemandeStatus> demandeStatusList = demandeStatusService.getAllDemandeStatus();
            model.addAttribute("demandeStatusList", demandeStatusList);

        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors de la sauvegarde: " + e.getMessage());
            return "home";
        }

        return "listedemande";
    }
}