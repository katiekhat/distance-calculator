package ge.softlab.distancecalculator.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "DataCurrent")
public class DataCurrent {

    @Id
    private String vehicleNumber;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date timestamp;


}