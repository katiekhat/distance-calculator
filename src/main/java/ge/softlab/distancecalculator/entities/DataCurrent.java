package ge.softlab.distancecalculator.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "data_current")
public class DataCurrent {

    @Id
    private String vehicleNumber;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private LocalDateTime timestamp;


}