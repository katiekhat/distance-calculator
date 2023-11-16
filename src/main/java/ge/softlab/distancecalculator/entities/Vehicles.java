package ge.softlab.distancecalculator.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vehicles")
public class Vehicles {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="vehicles_seq_generation")
    @SequenceGenerator(name="vehicles_seq_generation", sequenceName="vehicles_id_seq", allocationSize = 1)
    private Integer vehicleId;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "driver")
    private String driver;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "length")
    private Integer length;

    @Column(name = "width")
    private Integer width;

    @Column(name = "height")
    private Integer height;

    @Column(name = "payload")
    private Integer payload;

    @Column(name = "status")
    private Boolean status;

}
