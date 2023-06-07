package parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import parking.models.Booking;
/**
 * implements jpa voor crud operations
 * @author olivi
 *
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
/**
 * hier wordt door automatische een query gemaakt om de data uit de database te halen
 * @param name
 * @return
 */
	public Booking findBookingByVehiclePlate(String name);

}
