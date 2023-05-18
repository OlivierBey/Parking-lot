package parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import parking.models.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long>{

	

}
