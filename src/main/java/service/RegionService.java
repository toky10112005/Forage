package service;

// import dao.ObjectDAO;
import model.Region;
import java.util.ArrayList;
import repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public ArrayList<Region> getAllRegions() {
        return (ArrayList<Region>) regionRepository.findAll();
    }

    // public void addRegion(Region r) {
    //     regionRepository.save(r);
    // }
}