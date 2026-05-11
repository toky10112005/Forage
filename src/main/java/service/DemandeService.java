package service;

// import dao.ObjectDAO;
import model.Demande;
import java.util.ArrayList;
import repository.*;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeService {
    @Autowired
    private DemandeRepository demandeRepository;

    public ArrayList<Demande> getAllDemande() {
        return (ArrayList<Demande>) demandeRepository.findAll();
    }

    public Demande save(int id_personne, Date dateDemande, String lieu, String personne, String region) {
        Demande demande = new Demande();
        demande.setId(id_personne);
        demande.setDateDemande(dateDemande);
        demande.setLieu(lieu);
        demande.setPersonne(personne);
        demande.setRegion(region);
        return demandeRepository.save(demande);
    }

    // public void addDemande(demande d) {
    //     demandeRepository.save(d);
    // }
}