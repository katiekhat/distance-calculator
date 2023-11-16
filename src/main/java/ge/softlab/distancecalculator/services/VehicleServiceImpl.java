package ge.softlab.distancecalculator.services;

import ge.softlab.distancecalculator.entities.Vehicles;
import ge.softlab.distancecalculator.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    @Override
    public Vehicles createVehicle(Vehicles vehicles) {
        vehicles.setVehicleNumber(vehicles.getVehicleNumber());
        vehicles.setDriver(vehicles.getDriver());
        vehicles.setVehicleType(vehicles.getVehicleType());
        vehicles.setHeight(vehicles.getHeight());
        vehicles.setWidth(vehicles.getWidth());
        vehicles.setLength(vehicles.getLength());
        vehicles.setPayload(vehicles.getPayload());
        vehicles.setStatus(true);
        return vehicleRepository.save(vehicles);

    }

    @Override
    public List<Vehicles> searchVehicle(String vehicleType) {
        if (vehicleType != null) {
        return vehicleRepository.findByVehicleType(vehicleType);
    } else {
        return vehicleRepository.findAll();
    }
    }

    @Override
    public List<Vehicles> searchVehicleByNumber(String vehicleNumber) {
        if (vehicleNumber != null) {
            return vehicleRepository.findByVehicleNumber(vehicleNumber);
        } else {
            return vehicleRepository.findAll();
        }
    }
}
