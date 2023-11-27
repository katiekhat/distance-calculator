package ge.softlab.distancecalculator.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "vehicle_location_history")
public class VehicleLocationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer associatedVehicleId;

    private Double latitude;
    private Double longitude;
    private String vehicleNumber;

    private double distance;
    private LocalDateTime timestamp;

}

