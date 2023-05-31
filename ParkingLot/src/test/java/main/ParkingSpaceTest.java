package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import parking.ParkingLotApplication;
import parking.controllers.ParkingSpaceController;
import parking.services.ParkingspaceService;

@SpringBootTest(classes = ParkingLotApplication.class)
@Rollback
public class ParkingSpaceTest {

	@Autowired
	ParkingspaceService parkingSpaceService;
	
	@Test
	public void findAllspacesTest() {
		assertEquals(20, parkingSpaceService.findAllParkingSpaces().size());
		
	}
	@Test
	public void findfreeSpaceTest() {
		assertNotNull(parkingSpaceService.findFirstAvailable());
		
	}
	
}
