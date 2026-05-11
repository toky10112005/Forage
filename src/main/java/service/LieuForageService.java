package service;

import model.LieuForage;
import java.util.ArrayList;
import repository.LieuForageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LieuForageService {
    @Autowired
    private LieuForageRepository lieuForageRepository;

    public ArrayList<LieuForage> getAllLieuForage() {
        return (ArrayList<LieuForage>) lieuForageRepository.findAll();
    }

    public void save(String region, String district, String commune) {
        LieuForage lieuForage = new LieuForage();
        lieuForage.setRegion(region);
        lieuForage.setDistrict(district);
        lieuForage.setCommune(commune);
        lieuForageRepository.save(lieuForage);
    }
}
