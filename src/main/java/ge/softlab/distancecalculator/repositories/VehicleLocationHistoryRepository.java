package ge.softlab.distancecalculator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleLocationHistoryRepository extends JpaRepository <ge.softlab.distancecalculator.entities.VehicleLocationHistory, Integer> {
}
