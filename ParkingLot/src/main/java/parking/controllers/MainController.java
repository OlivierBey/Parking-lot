package parking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import parking.models.Booking;
import parking.models.ParkingSpace;
import parking.services.BookingService;
import parking.services.ParkingspaceService;

@Controller
public class MainController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	ParkingspaceService parkingspaceService;
	
	@GetMapping("/")
	public String main() {
		return controlAvailable();
		
		
	}
	
	private String controlAvailable() {
		List<Booking> bookings=bookingService.findAllBookings();
		System.out.println(bookings.size());
		
		for(Booking booking:bookings) {
			if(booking.getParkingSpace()!=null) {
				System.out.println(bookingService.findBookingbyId(booking.getId()).getParkingSpace().getId());
				
			parkingspaceService.findParkingspaceById(booking.getParkingSpace().getId()).setAvailable(false);
			}
		}
		if(parkingspaceService.availableParkingSpaces().size()>0) {
			return "main.html";}
		else {
			return "noRoom.html";
		}
	}
}
