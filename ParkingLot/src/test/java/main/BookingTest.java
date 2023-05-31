package main;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.ui.Model;

import parking.ParkingLotApplication;
import parking.controllers.BookingController;
import parking.models.Booking;
import parking.services.BookingService;

@SpringBootTest(classes = ParkingLotApplication.class)
@Rollback
public class BookingTest {

	@Autowired
	BookingController bookingController;
	
	@Autowired
	BookingService bookingService;
	
	
	@Test
	public void newBookingTest() {
		LocalDateTime time = LocalDateTime.now();
		Booking bookingtest= new Booking("1AAA222", time);
		bookingService.addBooking(bookingtest);
		assertNotNull(bookingService.findBookingByVehiclePlate("1AAA222"));
		bookingService.removeBooking(bookingService.findBookingByVehiclePlate("1AAA222").getId());
		assertTrue(true);
	}

	@Test
	public void stopBookingtest() {
		//LocalDateTime time = LocalDateTime.now();
		Booking bookingtest= new Booking("1AAA223", LocalDateTime.of(2023, 5, 10, 8, 05));
		bookingService.addBooking(bookingtest);
		long id=bookingService.findBookingByVehiclePlate("1AAA223").getId();
		bookingtest=bookingService.findBookingbyId(id);
		bookingtest.setStopTime(LocalDateTime.of(2023, 5, 11, 10, 55));
		bookingService.save(bookingtest);
		
		assertEquals(34.8,bookingService.calculate(bookingService.findBookingbyId(id)));
	}
}
