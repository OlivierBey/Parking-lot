package parking.repositories;
/**
 * implements jpa voor crud operations
 */
import org.springframework.data.jpa.repository.JpaRepository;

import parking.models.Booking;
import parking.models.History;

public interface HistoryRepository extends JpaRepository<History, Long> {

}
