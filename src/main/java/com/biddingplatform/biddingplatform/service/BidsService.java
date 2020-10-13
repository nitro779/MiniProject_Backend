package com.biddingplatform.biddingplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biddingplatform.biddingplatform.dao.BidsDAO;
import com.biddingplatform.biddingplatform.models.Bids;

@Service
public class BidsService {
	@Autowired
	private BidsDAO bidsDao;
	
	public int addBid(Bids bid) {
		return bidsDao.addBid(bid);
	}
	
	public List<Bids> getPlacedBids(int id){
		return bidsDao.getPlacedBids(id);
	}
	
	public List<Bids> getReceivedBids(int id){
		return bidsDao.getReceivedBids(id);
	}
	
	public int acceptBid(int bidId) {
		return bidsDao.acceptBid(bidId);
	}
	
	public Bids getBidsByBidId(int bidId) {
		return bidsDao.getBidByBidId(bidId);
	}
}
