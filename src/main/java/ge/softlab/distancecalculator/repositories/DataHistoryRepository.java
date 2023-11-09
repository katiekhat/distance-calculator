package ge.softlab.distancecalculator.repositories;

import ge.softlab.distancecalculator.entities.DataHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataHistoryRepository extends JpaRepository<DataHistory,Integer> {
}
