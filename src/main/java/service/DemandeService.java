package service;

// import dao.ObjectDAO;
import model.Demande;
import java.util.ArrayList;
import repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeService {
    @Autowired
    private DemandeRepository demandeRepository;

    public ArrayList<Demande> getAllDemande() {
        return (ArrayList<Demande>) demandeRepository.findAll();
    }

    // public void addDemande(demande d) {
    //     demandeRepository.save(d);
    // }
}