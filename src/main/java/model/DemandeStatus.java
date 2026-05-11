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

    private Date datemutation;

    public DemandeStatus() {
    }

    public DemandeStatus(int id, Demande demande, Status status, Date datemutation) {
        this.id = id;
        this.demande = demande;
        this.status = status;
        this.datemutation = datemutation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDatemutation() {
        return datemutation;
    }

    public void setDatemutation(Date datemutation) {
        this.datemutation = datemutation;
    }

}