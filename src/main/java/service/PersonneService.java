package service;

import model.Personne;
import repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    /**
     * Récupère toutes les personnes.
     * @return une liste de toutes les personnes.
     */
    public java.util.List<Personne> findAll() {
        return personneRepository.findAll();
    }

    /**
     * Sauvegarde une nouvelle personne.
     * @param personne L'objet Personne à sauvegarder.
     * @return la personne sauvegardée.
     */
    public Personne save(Personne personne) {
        return personneRepository.save(personne);
    }

    public Personne getPersonneByName(String nom) {
        java.util.List<Personne> personnes = personneRepository.findByNom(nom);
        return personnes.isEmpty() ? null : personnes.get(0);
    }
}
