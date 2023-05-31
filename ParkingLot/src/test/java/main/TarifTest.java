package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import parking.ParkingLotApplication;
import parking.services.TarifService;

@SpringBootTest(classes = ParkingLotApplication.class)
@Rollback
public class TarifTest {
	@Autowired
	TarifService tarifService;
	
	@Test
	public void findTarifTest() {
		String string= "promoday";
		assertEquals(20, tarifService.findTarifByTarifname(string).getPrice());
	}

}
