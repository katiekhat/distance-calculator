package ge.softlab.distancecalculator.controllers;

import ge.softlab.distancecalculator.entities.UserDomain;
import ge.softlab.distancecalculator.entities.Vehicles;
import ge.softlab.distancecalculator.repositories.VehicleRepository;
import ge.softlab.distancecalculator.services.VehicleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping("/createVehicle")
    public ResponseEntity<Vehicles> createVehicle(@RequestBody Vehicles vehicle) {
        Vehicles addedVehicle = vehicleService.createVehicle(vehicle);
        return ResponseEntity.ok(addedVehicle);
    }

    @GetMapping("/searchVehicle/{vehicleType}")
    public ResponseEntity<List<Vehicles>> searchVehicle(
            @PathVariable String vehicleType) {

        List<Vehicles> result = vehicleService.searchVehicle(vehicleType);
        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }
    @GetMapping("/searchVehicleByNumber")
    public ResponseEntity<List<Vehicles>> searchVehicleByNumber(
            @RequestParam String vehicleNumber) {

        List<Vehicles> result = vehicleService.searchVehicleByNumber(vehicleNumber);
        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }
}