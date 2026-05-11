package service;

import model.DemandeStatus;
import model.Demande;
import model.Status;
import java.util.ArrayList;
import repository.DemandeStatusRepository;
import repository.DemandeRepository;
import repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeStatusService {
    @Autowired
    private DemandeStatusRepository demandeStatusRepository;

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private StatusRepository statusRepository;

    public ArrayList<DemandeStatus> getAllDemandeStatus() {
        return (ArrayList<DemandeStatus>) demandeStatusRepository.findAll();
    }

    public void save(int demandeId, int statusId, java.util.Date datemutation) {
        Demande demande = demandeRepository.findById(demandeId).orElse(null);
        Status status = statusRepository.findById(statusId).orElse(null);

        if (demande != null && status != null) {
            DemandeStatus demandeStatus = new DemandeStatus();
            demandeStatus.setDemande(demande);
            demandeStatus.setStatus(status);
            demandeStatus.setDatemutation(datemutation);
            demandeStatusRepository.save(demandeStatus);
        }
    }
}
