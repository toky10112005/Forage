package model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class DemandeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @ManyToOne
    @JoinColumn(name = "demande_id")
    private Demande demande;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

     public DemandeStatus() {
    }

    public DemandeStatus(int id, model.Demande demande, model.Status status) {
        this.id = id;
        this.demande = demande;
        this.status = status;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     public model.Demande getDemande() {
        return demande;
    }

    public void setDemande(model.Demande demande) {
        this.demande = demande;
    }

     public model.Status getStatus() {
        return status;
    }

    public void setStatus(model.Status status) {
        this.status = status;
    }

}