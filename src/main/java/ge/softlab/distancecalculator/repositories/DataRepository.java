package ge.softlab.distancecalculator.repositories;

import ge.softlab.distancecalculator.entities.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository <Data , Integer> {
}
