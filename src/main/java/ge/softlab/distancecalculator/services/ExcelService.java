package ge.softlab.distancecalculator.services;

import ge.softlab.distancecalculator.entities.VehicleLocation;
import ge.softlab.distancecalculator.entities.VehicleLocationHistory;
import ge.softlab.distancecalculator.entities.Vehicles;
import ge.softlab.distancecalculator.repositories.VehicleLocationRepository;
import ge.softlab.distancecalculator.repositories.VehicleLocationHistoryRepository;
import ge.softlab.distancecalculator.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ExcelService {
    private final VehicleLocationRepository vehicleLocationRepository;
    private final VehicleRepository vehicleRepository;
    private final VehicleLocationHistoryRepository vehicleLocationHistoryRepository;

    public List<VehicleLocationHistory> readExcelFile(InputStream inputStream) throws IOException {
        List<VehicleLocationHistory> vehicleLocationHistoryList = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                VehicleLocationHistory vehicleLocationHistory = new VehicleLocationHistory();
                vehicleLocationHistory.setLatitude(row.getCell(0).getNumericCellValue());
                vehicleLocationHistory.setLongitude(row.getCell(1).getNumericCellValue());
                vehicleLocationHistory.setVehicleNumber(row.getCell(2).getStringCellValue());
                vehicleLocationHistory.setTimestamp(LocalDateTime.now());

                Vehicles associatedVehicle = vehicleRepository.findByVehicleNumber(vehicleLocationHistory.getVehicleNumber());
                if (associatedVehicle != null) {
                    vehicleLocationHistory.setAssociatedVehicleId(associatedVehicle.getVehicleId());
                }
                vehicleLocationHistoryList.add(vehicleLocationHistory);

                Optional<VehicleLocation> existingNumber = vehicleLocationRepository.findByVehicleNumber(vehicleLocationHistory.getVehicleNumber());
                if (existingNumber.isEmpty()) {
                    VehicleLocation newNumber = new VehicleLocation();
                    newNumber.setLatitude(vehicleLocationHistory.getLatitude());
                    newNumber.setLongitude(vehicleLocationHistory.getLongitude());
                    newNumber.setVehicleNumber(vehicleLocationHistory.getVehicleNumber());
                    newNumber.setTimestamp(LocalDateTime.now());
                    vehicleLocationRepository.save(newNumber);
                } else {
                    VehicleLocation existingData = existingNumber.get();
                    existingData.setLatitude(vehicleLocationHistory.getLatitude());
                    existingData.setLongitude(vehicleLocationHistory.getLongitude());
                    existingData.setTimestamp(LocalDateTime.now());
                    vehicleLocationRepository.save(existingData);
                }
            }
        }

        vehicleLocationHistoryRepository.saveAll(vehicleLocationHistoryList);

        return vehicleLocationHistoryList;
    }
}


