package com.biddingplatform.biddingplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biddingplatform.biddingplatform.models.Bids;
import com.biddingplatform.biddingplatform.service.BidsService;

@RestController
@CrossOrigin("*")
public class BidsController {
	
	@Autowired
	private BidsService bidsService;
	
	@PostMapping("/bids/add")
	public int addBid(@RequestBody Bids bid) {
		System.out.println(bid);
		return bidsService.addBid(bid);
	}
	
	@GetMapping("/bids/placed/{id}")
	public List<Bids> getPlacedBids(@PathVariable("id") int id){
		return bidsService.getPlacedBids(id);
	}
	
	@GetMapping("/bids/received/{id}")
	public List<Bids> getReceivedBids(@PathVariable("id") int id){
		return bidsService.getReceivedBids(id);
	}
	
	@PostMapping("/bids/accept/{id}")
	public int acceptBid(@PathVariable("id") int bidId) {
		return bidsService.acceptBid(bidId);
	}
	
	@GetMapping("/bids/get/{id}")
	public Bids getBidByBidId(@PathVariable("id") int id) {
		return bidsService.getBidsByBidId(id);
	}
}
