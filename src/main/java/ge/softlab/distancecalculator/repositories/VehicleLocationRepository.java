package ge.softlab.distancecalculator.repositories;

import ge.softlab.distancecalculator.entities.VehicleLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleLocationRepository extends JpaRepository<VehicleLocation,String> {
    Optional<VehicleLocation> findByVehicleNumber(String vehicleNumber);


//    List<String> findAllVehicleNumbers();
}
