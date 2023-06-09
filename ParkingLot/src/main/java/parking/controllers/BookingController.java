package parking.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import parking.models.Booking;
import parking.services.BookingService;
import parking.services.ParkingspaceService;
/**
 * controllers worden gebruikt als verbinding tussen de frontend en de applicatie
 * Deze wordt gebruikt bij het starten en stoppen van een booking
 * @author olivi
 *
 */
@Controller
public class BookingController {

	@Autowired
	BookingService bookingService;
	@Autowired
	ParkingspaceService parkingspaceService;
	@Autowired
	ParkingSpaceController parkingSpaceController;

	@PostMapping(value = "/startBooking")
	public String newBooking(@RequestParam(name = "name") String name, Model model) {

		LocalDateTime starttime = LocalDateTime.now();
		Booking booking = new Booking(name, starttime);
		bookingService.addBooking(booking);
		model.addAttribute("bookingId", booking.getId());
		return parkingSpaceController.getAllparkingSpaces(model);

	}

	@PostMapping("stopBooking")
	public String stopBooking(@RequestParam(name = "name") String name, Model model) {
		LocalDateTime stopTime = LocalDateTime.now();
		Booking booking = bookingService.findBookingByVehiclePlate(name);
		booking.setStopTime(stopTime);
		booking.setTotalPrice(bookingService.calculate(booking));
		bookingService.save(booking);

		model.addAttribute("bookingId", booking.getId());
		model.addAttribute("name", booking.getVehiclePlate());
		model.addAttribute("parkingSpaceId", booking.getParkingSpace().getId());
		model.addAttribute("startTime", booking.getStarTime());
		model.addAttribute("stopTime", booking.getStopTime());
		model.addAttribute("totalPrice", booking.getTotalPrice());
		return "calculate.html";

	}

}
