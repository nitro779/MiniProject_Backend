package com.biddingplatform.biddingplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biddingplatform.biddingplatform.dao.ProductDAO;
import com.biddingplatform.biddingplatform.models.Product;

@Service
public class ProductsService {

	@Autowired
	private ProductDAO productDao;
	
	public int addProduct(Product product){
		return productDao.saveProduct(product);
	}
	
	public List<Product> getAllProducts(String username){
		return productDao.getAllProducts(username);
	}
	
	public List<Product> getMyProducts(String username){
		return productDao.getMyProducts(username);
	}
	
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}
	
	public int deleteProductById(int id) {
		return productDao.deleteProductById(id);
	}
}
