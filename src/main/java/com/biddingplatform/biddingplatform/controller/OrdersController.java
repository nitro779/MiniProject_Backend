package com.biddingplatform.biddingplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biddingplatform.biddingplatform.models.Order;
import com.biddingplatform.biddingplatform.service.OrdersService;

@RestController
@CrossOrigin("*")
public class OrdersController {
	
	@Autowired
	private OrdersService orderService;
	
	
	@PostMapping("orders/add")
	public int addOrder(@RequestBody Order order) {
		return orderService.addOrders(order);
	}
	
	@GetMapping("orders/placed/{id}")
	public List<Order> getPlacedOrders(@PathVariable("id")int customer_id){
		return orderService.getPlacedOrders(customer_id);
	}
	
	@GetMapping("orders/received/{id}")
	public List<Order> getReceivedOrders(@PathVariable("id")int seller_id){
		return orderService.getReceivedOrders(seller_id);
	}
	
	@GetMapping("orders/placed/{sortType}/{id}")
	public List<Order> getSortedOrders(@PathVariable("id") int customer_id,@PathVariable("sortType")String by){
		System.out.println(customer_id+by);
		return orderService.getSortedOrders(by, customer_id);
	}
}
