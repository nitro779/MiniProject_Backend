package com.biddingplatform.biddingplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biddingplatform.biddingplatform.models.CardDetails;
import com.biddingplatform.biddingplatform.service.CardDetailsService;

@RestController
@CrossOrigin("*")
public class CardDetailsController {
	
	@Autowired
	private CardDetailsService cardDetailsService;
	
	@PostMapping("cards/add")
	private int addCardDetails(@RequestBody CardDetails cardDetails) {
		System.out.println(cardDetails);
		return cardDetailsService.addCardDetails(cardDetails);
	}
	
	@GetMapping("cards/get/{customer_id}")
	private List<CardDetails> getCardDetailsByCustomer(@PathVariable("customer_id") int customerId){
		return cardDetailsService.findCardDetailsByCustomer(customerId);
	}
}
