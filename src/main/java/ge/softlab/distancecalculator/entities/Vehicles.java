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

    private String vehicleNumber;

    private String driver;

    private String vehicleType;

    private Integer length;

    private Integer width;

    private Integer height;

    private Integer payload;

    private Boolean status;

}
