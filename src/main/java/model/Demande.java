package model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    private Date dateDemande;
    private String lieu;
    private String personne;
    private String region;

    public Demande() {}

    public Demande(int id, Date dateDemande, String lieu, String personne, String region
            ) {
        this.id = id;
        this.dateDemande = dateDemande;
        this.lieu = lieu;
        this.personne = personne;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

     public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

 public String getPersonne() {
        return personne;
    }

    public void setPersonne(String personne) {
        this.personne = personne;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    

}
