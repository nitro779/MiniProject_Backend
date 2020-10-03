package basicauth.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basicauth.demo.models.CardDetails;
import basicauth.demo.repositories.CardDetailsRepository;

@Service
public class CardDetailsService {
	
	@Autowired
	private CardDetailsRepository cardDetailsRepository;
	
	public boolean saveCard(CardDetails card) {
		try {
			if(cardDetailsRepository.findCardDetailsBycardnumber(card.getCardnumber())==null) {
				cardDetailsRepository.save(card);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}