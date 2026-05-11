package model;

import jakarta.persistence.*;

@Entity
public class LieuForage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int idDemande;
    private String region;
    private String district;
    private String commune;

    public LieuForage() {}

    public LieuForage(int id, int idDemande, String region, String district, String commune) {
        this.id = id;
        this.idDemande = idDemande;
        this.region = region;
        this.district = district;
        this.commune = commune;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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
}
