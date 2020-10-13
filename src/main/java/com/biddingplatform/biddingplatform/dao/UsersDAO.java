package com.biddingplatform.biddingplatform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.biddingplatform.biddingplatform.models.User;
import com.biddingplatform.biddingplatform.service.EmailService;


@Repository
public class UsersDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmailService emailService;
	
	private static final class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setFullname(rs.getString("fullname"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			return user;
		}
		
	}
	
	public int saveUser(User user){
		System.out.println(user);	
		String query = "insert into al387_users_tbl values('"+user.getId()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getFullname()+"','"+user.getEmail()+"')";
		return jdbcTemplate.update(query);
	}
	
	public User findUserByUsername(String username){
		try {
			String query = "select * from al387_users_tbl where username=?";
			User user = jdbcTemplate.queryForObject(query, new Object[] {username}, new UserRowMapper());
			return user;
		}catch(Exception e) {
			return null;
		}
	}
	
	public User findUserByEmail(String email) {
		try {
			String query = "select * from al387_users_tbl where email=?";
			return jdbcTemplate.queryForObject(query, new Object[] {email}, new UserRowMapper());
		}catch(Exception e){
			return null;
		}
	}
	
	
	public int findUserIdByUserName(String name) {
		String query = "select id from al387_users_tbl where username=?";
		return jdbcTemplate.queryForObject(query, new Object[] {name}, Integer.class);
	}
	
	public User getUserName(int id) {
		String query = "select * from al387_users_tbl where id=?";
		try {
			User user =  jdbcTemplate.queryForObject(query, new Object[] {id}, new UserRowMapper());
			return user;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<User> findAllUsers(){
		String query = "select * from al387_users_tbl";
		try {
			return jdbcTemplate.query(query, new UserRowMapper());
		}catch(Exception e) {
			return null;
		}
	}
	
	public int forgotPassword(String username) {
		if(findUserIdByUserName(username)==1) {
			String query = "select * from al387_users_tbl where username=?";
			try {
				User user = jdbcTemplate.queryForObject(query, new Object[] {username},new UserRowMapper());
				System.out.println(user.getEmail());
				emailService.sendEmail(user.getEmail(), user.getPassword());
				return 1;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return 0;
			}
		}
		return 10;
	}
}
