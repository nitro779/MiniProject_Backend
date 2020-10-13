package com.biddingplatform.biddingplatform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.biddingplatform.biddingplatform.models.Product;

@Repository
public class ProductDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UsersDAO usersDAO;
	
	private static final class ProductRowMapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setPid(rs.getInt("pid"));
			product.setSeller_id(rs.getInt("seller_id"));
			product.setCategory(rs.getString	("category"));
			product.setDescription(rs.getNString("prod_desc"));
			product.setImage(rs.getString("image"));
			product.setInitialbid(rs.getFloat("initial_bid"));
			product.setProductname(rs.getString("prod_name"));
			return product;
		}
		
	}
	
	public int saveProduct(Product product) {
		String sql = "insert into al387_products_tbl values('"+product.getPid()+"','"+product.getProductname()+"','"+product.getDescription()+"','"+product.getImage()+"','"+product.getInitialbid()+"','"+product.getCategory()+"','"+product.getSeller_id()+"')";
		try {
			return jdbcTemplate.update(sql);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public List<Product> getAllProducts(String username){
		int userId = usersDAO.findUserIdByUserName(username);
		String sql = "select * from al387_products_tbl where seller_id != ? and pid not in (select product_id from al387_bids_tbl where bid_status=1)";
		try {
			return jdbcTemplate.query(sql, new Object[] {userId}, new ProductRowMapper());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<Product> getMyProducts(String username){
		int userId = usersDAO.findUserIdByUserName(username);
		String sql = "select * from al387_products_tbl where seller_id = ? and pid not in (select product_id from al387_bids_tbl where bid_status=1)";
		try {
			return jdbcTemplate.query(sql, new Object[] {userId}, new ProductRowMapper());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Product getProductById(int id){
		String query = "select * from al387_products_tbl where pid=?";
		try {
			return jdbcTemplate.queryForObject(query, new Object[] {id}, new ProductRowMapper());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public int deleteProductById(int id) {
		String query = "delete from al387_products_tbl where pid=?";
		try {
			return jdbcTemplate.update(query,new Object[] {id});
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
}
