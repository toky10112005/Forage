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
    private String district;
    private String commune;
    private String fokotany;
    private String Lieu;

    public Demande() {}

    public Demande(int id, Date dateDemande, String lieu, String personne, String district, String commune,
            String fokotany, String Lieu) {
        this.id = id;
        this.dateDemande = dateDemande;
        this.lieu = lieu;
        this.personne = personne;
        this.district = district;
        this.commune = commune;
        this.fokotany = fokotany;
        this.Lieu = Lieu;
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
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }
     public String getFokotany() {
        return fokotany;
    }

    public void setFokotany(String fokotany) {
        this.fokotany = fokotany;
    }
    
        // public String getLieu() {
        //     return Lieu;
        // }

}
