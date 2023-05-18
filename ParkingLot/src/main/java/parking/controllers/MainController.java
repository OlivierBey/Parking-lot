package parking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import parking.services.BookingService;

@Controller
public class MainController {

	@Autowired
	private BookingService bookingService;
	
	
	
	@GetMapping("/")
	public String main() {
		
		return "main.html";
		
	}
	
	
}
