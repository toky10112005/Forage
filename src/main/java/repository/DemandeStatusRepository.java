package repository;

import model.DemandeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DemandeStatusRepository extends JpaRepository<DemandeStatus, Integer> {
    
}
