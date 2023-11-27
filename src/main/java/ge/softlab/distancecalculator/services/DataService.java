package ge.softlab.distancecalculator.services;

import ge.softlab.distancecalculator.entities.VehicleLocationHistory;
import ge.softlab.distancecalculator.repositories.VehicleLocationHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DataService {
    private final VehicleLocationHistoryRepository vehicleLocationHistoryRepository;


    public void saveDataToDatabase(List<VehicleLocationHistory> vehicleLocationHistoryList) {
        this.vehicleLocationHistoryRepository.saveAll(vehicleLocationHistoryList);
    }


    public List<VehicleLocationHistory> getData() {
        return vehicleLocationHistoryRepository.findAll();
    }
}
