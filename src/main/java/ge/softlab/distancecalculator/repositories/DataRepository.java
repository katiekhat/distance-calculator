package ge.softlab.distancecalculator.repositories;

import ge.softlab.distancecalculator.entities.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository <Data , Integer> {
}
