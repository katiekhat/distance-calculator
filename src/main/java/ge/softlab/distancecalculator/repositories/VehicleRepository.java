package ge.softlab.distancecalculator.repositories;

import ge.softlab.distancecalculator.entities.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicles,Integer> {
    List<Vehicles> findByVehicleType(String vehicleType);

//    List<Vehicles> findByVehicleNumber(String vehicleNumber);
    Vehicles findByVehicleNumber(String vehicleNumber);


}
