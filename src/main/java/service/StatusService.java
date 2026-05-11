package service;

import model.Status;
import java.util.ArrayList;
import repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public ArrayList<Status> getAllStatus() {
        return (ArrayList<Status>) statusRepository.findAll();
    }

    public Status getStatusById(int id) {
        return statusRepository.findById(id).orElse(null);
    }

    public Status save(Status status) {
        return statusRepository.save(status);
    }
}
