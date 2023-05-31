package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import parking.ParkingLotApplication;
import parking.models.History;
import parking.services.HistoryService;
@SpringBootTest(classes = ParkingLotApplication.class)
@Rollback
public class HistoryTest {
	
	@Autowired
	HistoryService historyService;
	
	@Test
	void addHistoryTest(){
		historyService.addToHistory(new History("TESTING"));
		assertTrue(true);
	}

}
