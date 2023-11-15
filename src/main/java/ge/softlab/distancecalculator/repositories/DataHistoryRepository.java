package ge.softlab.distancecalculator.repositories;

import ge.softlab.distancecalculator.entities.DataHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataHistoryRepository extends JpaRepository<DataHistory,Integer> {
}
