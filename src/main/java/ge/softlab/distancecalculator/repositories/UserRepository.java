package ge.softlab.distancecalculator.repositories;

import ge.softlab.distancecalculator.entities.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserDomain, Integer> {

    Optional<UserDomain> findAllByUsername(String username);
}
