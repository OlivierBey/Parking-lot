package parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import parking.models.Tarif;

@Repository
public interface TarifRepository extends JpaRepository<Tarif, Long> {

}
