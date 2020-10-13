package com.biddingplatform.biddingplatform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.biddingplatform.biddingplatform.models.CardDetails;

@Repository
public class CardDetailsDAO {
	
	
	private static final class CardDetailsRowMapper implements RowMapper<CardDetails>{

		@Override
		public CardDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			CardDetails card = new CardDetails();
			card.setCard_id(rs.getInt(1));
			card.setCardholder(rs.getString(2));
			card.setCardnumber(rs.getInt(3));
			card.setMonth(rs.getInt(4));
			card.setYear(rs.getInt(5));
			card.setCvv(rs.getInt(6));
			card.setCustomer_id(rs.getInt(7));
			return card;
		}
		
	}
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addCardDetails(CardDetails card) {
		String query = "insert into al387_card_details_tbl values('"+card.getCard_id()+"','"+card.getCardholder()+"','"+card.getCardnumber()+"','"+card.getMonth()+"','"+card.getYear()+"','"+card.getCvv()+"','"+card.getCustomer_id()+"')";
		try {
			return jdbcTemplate.update(query);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public List<CardDetails> findCardDetailsByCustomerId(int customerId){
		String query = "select * from al387_card_details_tbl where customer_id=?";
		try {
			return jdbcTemplate.query(query, new Object[] {customerId}, new CardDetailsRowMapper());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
