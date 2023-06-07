package parking.repositories;
/**
 * implements jpa voor crud operations
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import parking.models.Tarif;

@Repository
public interface TarifRepository extends JpaRepository<Tarif, Long> {
/**
 * hier wordt door automatische een query gemaakt om de data uit de database te halen
 * @param string
 * @return
 */
	public Tarif findTarifByTarifname(String string);

}
