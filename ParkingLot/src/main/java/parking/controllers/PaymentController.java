package parking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import parking.models.Booking;
import parking.models.History;
import parking.services.BookingService;
import parking.services.HistoryService;

@Controller
public class PaymentController {
	
	@Autowired
	BookingService bookingService;
	@Autowired
	HistoryService historyService;

	@GetMapping("stopBooking/calculate")
	public String confirmPayment(@RequestParam(name="bookingId") Integer bookingId)  {
		Booking booking=bookingService.findBookingbyId(bookingId);
		booking.getParkingSpace().setAvailable(true);
		
		String stringBooking= booking.getVehiclePlate()
				.concat(booking.getParkingSpace().getLocation()).concat(" & ")
				.concat(booking.getStarTime().toString()).concat(" & ")
				.concat(booking.getStopTime().toString()).concat(" & ");
		stringBooking+=booking.getTotalPrice();
				
		
		historyService.addToHistory(new History(stringBooking));
		
		
		bookingService.removeBooking(bookingId);
		
		return "main";
	}
}
