
package parking.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import parking.models.Booking;
import parking.models.ParkingSpace;
import parking.services.BookingService;
import parking.services.ParkingspaceService;

@Controller
public class ParkingSpaceController {

	@Autowired
	ParkingspaceService parkingspaceService;
	@Autowired
	BookingService bookingService;

	@GetMapping(value = "/startBooking/space")
	public String getAllparkingSpaces(Model model) {
		System.out.println("start parking");
		List<ParkingSpace> parkingSpaces = parkingspaceService.findAllParkingSpaces();

		for (ParkingSpace parkingSpace : parkingSpaces) {

		}
		model.addAttribute("parkingSpaces", parkingSpaces);
		model.addAttribute("findFirstAvailable", parkingspaceService.findFirstAvailable());

		return "parkingspace";
	}

	@PostMapping("/startBooking/space")
	public String newBooking(@RequestParam(name = "parkingSpaceId") Integer parkingSpaceId,
			@RequestParam(name = "bookingId") Integer bookingId, Model model) {
		System.out.println("Confirm " + bookingId + " " + parkingSpaceId);
		ParkingSpace parkingSpace = parkingspaceService.findParkingspaceById(parkingSpaceId);
		parkingSpace.setAvailable(false);
		bookingService.findBookingbyId(bookingId).setParkingSpace(parkingSpace);
		;

		model.addAttribute("bookingId", bookingId);
		model.addAttribute("name", bookingService.findBookingbyId(bookingId).getVehiclePlate());
		model.addAttribute("parkingSpaceId", parkingspaceService.findParkingspaceById(parkingSpaceId).getLocation());
		model.addAttribute("startTime", bookingService.findBookingbyId(bookingId).getStarTime());
		return "confirmBooking.html";
	}

}
