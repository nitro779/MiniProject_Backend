package com.biddingplatform.biddingplatform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.biddingplatform.biddingplatform.models.Bids;
import com.biddingplatform.biddingplatform.service.EmailService;
import com.biddingplatform.biddingplatform.service.UsersService;

@Repository
public class BidsDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UsersService usersService;
	@Autowired
	private EmailService emailService;
	private static final class BidsRowMapper implements RowMapper<Bids>{

		@Override
		public Bids mapRow(ResultSet rs, int rowNum) throws SQLException {
			Bids bid = new Bids();
			bid.setBid_id(rs.getInt(1));
			bid.setBidval(rs.getFloat(2));
			bid.setCustomer_id(rs.getInt(3));
			bid.setProduct_id(rs.getInt(4));
			bid.setStatus(rs.getInt(5));
			return bid;
		}
	}
	
	public int addBid(Bids bid) {
		if(checkBid(bid.getCustomer_id(), bid.getProduct_id())==null) {
			System.out.println("inside If");
			System.out.println(bid);
			String query = "insert into al387_bids_tbl values('"+bid.getBid_id()+"','"+bid.getBidval()+"','"+bid.getCustomer_id()+"','"+bid.getProduct_id()+"','"+bid.getStatus()+"')";
			return jdbcTemplate.update(query);
		}else {
			String query = "update al387_bids_tbl set bid_val=? where customer_id=? and product_id=?";
			try {
				return jdbcTemplate.update(query,new Object[] {bid.getBidval(),bid.getCustomer_id(),bid.getProduct_id()});
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return 0;
			}
		}
	}
	
	public List<Bids> getReceivedBids(int id){
		String query = "select * from al387_bids_tbl where product_id=?";
		try {
			return jdbcTemplate.query(query, new Object[] {id}, new BidsRowMapper());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<Bids> getPlacedBids(int id){
		String query = "select * from al387_bids_tbl where customer_id=?";
		try {
			return jdbcTemplate.query(query, new Object[] {id}, new BidsRowMapper());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Bids checkBid(int custId, int prodId) {
		String query = "select * from al387_bids_tbl where customer_id =? and product_id=?";
		try{
			return jdbcTemplate.queryForObject(query, new Object[] {custId,prodId},new BidsRowMapper());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public int acceptBid(int bidId) {
		String query = "update al387_bids_tbl set bid_status=1 where bid_id=?";
		try{
			jdbcTemplate.update(query, new Object[] {bidId});
			String toEmail = usersService.getUsername(getBidByBidId(bidId).getCustomer_id()).getEmail();
			System.out.println(toEmail);
			emailService.sendEmail(toEmail);
			return 1;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
		
	}
	
	public Bids getBidByBidId(int bidId) {
		String query = "select * from al387_bids_tbl where bid_id=?";
		try{
			return jdbcTemplate.queryForObject(query, new Object[] {bidId},new BidsRowMapper());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
