package com.biddingplatform.biddingplatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biddingplatform.biddingplatform.dao.OrdersDAO;
import com.biddingplatform.biddingplatform.models.Order;

@Service
public class OrdersService {

	@Autowired
	private OrdersDAO ordersDao;
	
	@Autowired
	private ProductsService productsService;
	
	public int addOrders(Order order) {
		System.out.println("Entered into Order Service");
		if(ordersDao.addOrder(order)==1)
		{
			productsService.deleteProductById(order.getProduct_id());
			return 1;
		}
		return 0;
	}
	
	public List<Order> getPlacedOrders(int customer_id){
		return ordersDao.getPlacedOrders(customer_id);
	}
	
	public List<Order> getReceivedOrders(int seller_id){
		return ordersDao.getReceivedOrders(seller_id);
	}
	
	public List<Order> getSortedOrders(String sortType,int customer_id){
		return ordersDao.getSortedOrders(sortType, customer_id);
	}
}
