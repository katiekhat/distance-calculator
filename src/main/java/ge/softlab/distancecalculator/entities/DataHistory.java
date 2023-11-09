package ge.softlab.distancecalculator.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "DataHistory")
public class DataHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "vehicle_number")
    private String vehicleNumber;
    @Column(name = "last_connected")
    private Date lastConnected;



}
