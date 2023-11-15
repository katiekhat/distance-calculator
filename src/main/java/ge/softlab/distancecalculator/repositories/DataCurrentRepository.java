package ge.softlab.distancecalculator.repositories;

import ge.softlab.distancecalculator.entities.DataCurrent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DataCurrentRepository extends JpaRepository<DataCurrent,String> {
    DataCurrent findByVehicleNumber(String vehicleNumber);
}
