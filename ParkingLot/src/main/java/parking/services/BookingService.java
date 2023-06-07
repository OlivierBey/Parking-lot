package parking.services;
/**
 * service klasse waar alle methodes worden verzameld
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import parking.models.Booking;
import parking.repositories.BookingRepository;

@Service
@Transactional
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	TarifService tarifService;

	public BookingService() {
	}

	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	public Booking findBookingbyId(long id) {
		return bookingRepository.findById(id).get();
	}

	public List<Booking> findAllBookings() {
		return bookingRepository.findAll();
	}

	public void addBooking(Booking b) {
		bookingRepository.save(b);
	}

	public void removeBooking(long id) {
		bookingRepository.deleteById(id);
	}

	public void save(Booking booking) {
		bookingRepository.save(booking);

	}
/**
 * calculate berekend de totalprice adhv Tarif tabel en startTime en stopTime
 * @param booking
 * @return
 */
	public double calculate(Booking booking) {

		int days = booking.getStopTime().getDayOfYear() - booking.getStarTime().getDayOfYear();
		int minutes = ((booking.getStopTime().getHour() - booking.getStarTime().getHour()) * 60);
		minutes += (booking.getStopTime().getMinute() - booking.getStarTime().getMinute());
		if (days > 9) {
			return (tarifService.findTarifByTarifname("promoday").getPrice() * days)
					+ (tarifService.findTarifByTarifname("minute").getPrice() * minutes);
		} else {

			return (tarifService.findTarifByTarifname("day").getPrice() * days)
					+ (tarifService.findTarifByTarifname("minute").getPrice() * minutes);
		}

	}

	public Booking findBookingByVehiclePlate(String name) {
		return bookingRepository.findBookingByVehiclePlate(name);

	}
}
