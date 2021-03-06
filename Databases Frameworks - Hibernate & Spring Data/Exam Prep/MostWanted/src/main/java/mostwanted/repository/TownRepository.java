package mostwanted.repository;

import mostwanted.domain.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, Integer> {
    Optional<Town> findByName(String name);

}
