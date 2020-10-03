package basicauth.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import basicauth.demo.models.CardDetails;
import basicauth.demo.services.CardDetailsService;

@RestController
@CrossOrigin("*")
public class CardDetailsController {
	
	@Autowired
	private CardDetailsService CardDetailsService;
	
	
	@PostMapping("/cards")
	public boolean saveCard(@RequestBody CardDetails cardDetails) {
		return CardDetailsService.saveCard(cardDetails);
	}
}
