package basicauth.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import basicauth.demo.models.Orders;
import basicauth.demo.services.OrdersService;

@RestController
@CrossOrigin("*")
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@PostMapping("/order")
	public boolean addOrder(@RequestBody Orders order) {
		return ordersService.addOrder(order);
	}
	
	@GetMapping("/order/{uname}")
	public List<Orders> getOrders(@PathVariable("uname") String uname) {
		return ordersService.getOrders(uname);
	}
}
