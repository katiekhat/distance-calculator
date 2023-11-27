//package ge.softlab.distancecalculator.services;
//
//import ge.softlab.distancecalculator.repositories.VehicleLocationRepository;
//import ge.softlab.distancecalculator.repositories.VehicleRepository;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CompareService {
//    public final VehicleLocationRepository vehicleLocationRepository;
//    public final VehicleRepository vehicleRepository;
//    List<String> UnregisteredVehiclesInExcel(){
//        List<String> vehicleNumbersInExcel=vehicleLocationRepository.findAllVehicleNumbers();
//        List<String> vehicleNumbersInVehicles = vehicleRepository.findAllVehicleNumbers();
//
//        vehicleNumbersInVehicles.removeAll(vehicleNumbersInExcel);
//        return vehicleNumbersInVehicles;
//
//
//
//    }
//    List<String> unregisteredVehiclesInTable() {
//        List<String> vehicleNumbersInExcel = vehicleLocationRepository.findAllVehicleNumbers();
//        List<String> vehicleNumbersInVehicles = vehicleRepository.findAllVehicleNumbers();
//
//        vehicleNumbersInExcel.removeAll(vehicleNumbersInVehicles);
//
//        return vehicleNumbersInExcel;
//
//    }
//
//
//}
