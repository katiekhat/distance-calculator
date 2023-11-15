package ge.softlab.distancecalculator.services;

import ge.softlab.distancecalculator.entities.DataCurrent;
import ge.softlab.distancecalculator.entities.DataHistory;
import ge.softlab.distancecalculator.repositories.DataCurrentRepository;
import ge.softlab.distancecalculator.repositories.DataHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor


public class LocationServiceImpl implements LocationService {
    private final DataCurrentRepository dataCurrentRepository;
    private final DataHistoryRepository dataHistoryRepository;

    @Override
    public void updateLocation(double longitude, double latitude, String vehicleNumber) {
        DataCurrent currentData = dataCurrentRepository.findByVehicleNumber(vehicleNumber);

        if (currentData != null) {
            // Update existing record in DataCurrent
            currentData.setLongitude(longitude);
            currentData.setLatitude(latitude);
            currentData.setTimestamp(LocalDateTime.now());
            dataCurrentRepository.save(currentData);
        } else {
            // Add new record to DataCurrent
            DataCurrent newData = new DataCurrent();
            newData.setVehicleNumber(vehicleNumber);
            newData.setLongitude(longitude);
            newData.setLatitude(latitude);
            newData.setTimestamp(LocalDateTime.now());
            dataCurrentRepository.save(newData);
        }

        DataHistory historyData = new DataHistory();
        historyData.setVehicleNumber(vehicleNumber);
        historyData.setLongitude(longitude);
        historyData.setLatitude(latitude);
        historyData.setLastConnected(LocalDateTime.now());
        dataHistoryRepository.save(historyData);
    }

    @Override
    public List<DataHistory> getAllHistoryData() {
        return dataHistoryRepository.findAll();
    }
}
