package com.biddingplatform.biddingplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biddingplatform.biddingplatform.models.Product;
import com.biddingplatform.biddingplatform.service.ProductsService;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductsService productsService;
	
	@PostMapping("products/add")
	public int addProduct(@RequestBody Product product) {
		try{
			productsService.addProduct(product);
		}catch(Exception e) {
			
		}
		return 1;
		//return productsService.addProduct(product);
	}
	
	@GetMapping("products/all/{username}")
	public List<Product> getProducts(@PathVariable("username") String username){
		return productsService.getAllProducts(username);
	}
	
	
	@GetMapping("products/my/{username}")
	public List<Product> getMyProducts(@PathVariable("username") String username){
		return productsService.getMyProducts(username);
	}
	
	@GetMapping("products/product/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return productsService.getProductById(id);
	}
}
