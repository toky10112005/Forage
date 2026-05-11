package repository;

import model.LieuForage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuForageRepository extends JpaRepository<LieuForage, Integer> {}
