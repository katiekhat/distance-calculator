package ge.softlab.distancecalculator.services;

import ge.softlab.distancecalculator.entities.Vehicles;

import java.util.List;

public interface VehicleService {
    Vehicles createVehicle(Vehicles vehicles);
    List<Vehicles> searchVehicle(String vehicleType);

    List<Vehicles> searchVehicleByNumber(String vehicleNumber);
}
