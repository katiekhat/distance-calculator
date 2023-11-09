package ge.softlab.distancecalculator.repositories;

import ge.softlab.distancecalculator.entities.DataCurrent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataCurrentRepository extends JpaRepository<DataCurrent,String> {
    DataCurrent findByVehicleNumber(String vehicleNumber);
}
