package parking.services;

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
	
	public BookingService() {}
	
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository= bookingRepository;
	}
	public Booking findBookingbyId(long id) {
		return bookingRepository.findById(id).get();
	}
	
	public List<Booking> findAllBookings(){
		return bookingRepository.findAll();
	}
	public void addBooking(Booking b) {
		bookingRepository.save(b);
	}
	public void removeBooking(long id) {
		bookingRepository.deleteById(id);
	}

	public Booking findBookingByName(String name) {
		for (Booking booking : findAllBookings()) {
			if(booking.getVehiclePlate().equals(name)) {
				return booking;
			}
		}return null;
		
	}

	public void save(Booking booking) {
		bookingRepository.save(booking);
		
	}

	public double calculate(Booking booking) {
		
			int days= booking.getStopTime().getDayOfYear()-booking.getStarTime().getDayOfYear();
			int minutes = ((booking.getStopTime().getHour()-booking.getStarTime().getHour())*60);
			minutes+= (booking.getStopTime().getMinute()-booking.getStarTime().getMinute());
			
			return (tarifService.findTarifByName("day").getPrice()*days)+
					(tarifService.findTarifByName("minute").getPrice()*minutes);
		
	}
}
