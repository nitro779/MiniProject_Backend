package com.biddingplatform.biddingplatform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.biddingplatform.biddingplatform.models.Order;

@Repository
public class OrdersDAO {


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final class OrdersRowMapper implements RowMapper<Order>{

		@Override
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			Order order = new Order();
			order.setOrder_id(rs.getInt(1));
			order.setOrder_date(rs.getDate(2));
			order.setProduct_id(rs.getInt(3));
			order.setProduct_name(rs.getString(4));
			order.setProduct_image(rs.getString(5));
			order.setCategory(rs.getString(6));;
			order.setPrice(rs.getFloat(7));
			order.setCustomer_id(rs.getInt(8));
			order.setSeller_id(rs.getInt(9));
			return order;
		}
		
	}
	
	public int addOrder(Order order) {
		System.out.println("Adding the Given Order Details");
		String query = "insert into al387_orders_tbl values('"+order.getOrder_id()+"','"+order.getOrder_date()+"','"+order.getProduct_id()+"','"+order.getProduct_name()+"','"+order.getProduct_image()+"','"+order.getCategory()+"','"+order.getPrice()+"','"+order.getCustomer_id()+"','"+order.getSeller_id()+"')";
		try {
			return jdbcTemplate.update(query);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Order Not Accepted");
			return 0;
		}
	}
	
	public List<Order> getPlacedOrders(int customer_id){
		String query = "select * from al387_orders_tbl where customer_id=?";
		try {
			return jdbcTemplate.query(query, new Object[] {customer_id}, new OrdersRowMapper());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<Order> getReceivedOrders(int seller_id){
		String query = "select * from al387_orders_tbl where seller_id=?";
		try {
			return jdbcTemplate.query(query, new Object[] {seller_id}, new OrdersRowMapper());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<Order> getSortedOrders(String sortType,int customer_id){
		System.out.println(sortType+customer_id);
		LocalDate date = LocalDate.now();
		String query;
		switch(sortType.toLowerCase()) {
		case "today":
			query = "select * from al387_orders_tbl where order_date=curdate() and customer_id=?";
			return jdbcTemplate.query(query,new Object[] {customer_id},new OrdersRowMapper());
		case "week":
			query = "select * from al387_orders_tbl where dayofweek(order_date)=dayofweek(curdate()) and customer_id=?";
			return jdbcTemplate.query(query,new Object[] {customer_id},new OrdersRowMapper());
		case "month":
			int month = date.getMonthValue();
			System.out.println(month);
			query = "select * from al387_orders_tbl where month(order_date) = ? and customer_id=?";
			return jdbcTemplate.query(query,new Object[] {month,customer_id},new OrdersRowMapper());
		case "year":
			int year = date.getYear();
			query = "select * from al387_orders_tbl where year(order_date) = ? and customer_id=?";
			return jdbcTemplate.query(query,new Object[] {year,customer_id},new OrdersRowMapper());
		default:
			return null;
		}
	}
}
