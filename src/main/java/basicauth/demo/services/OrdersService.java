package basicauth.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basicauth.demo.models.Customer;
import basicauth.demo.models.Orders;
import basicauth.demo.repositories.BidsRepository;
import basicauth.demo.repositories.CustomerRepository;
import basicauth.demo.repositories.OrdersRepository;
import basicauth.demo.repositories.ProductRepository;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private BidsRepository bidsRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	
	
	public boolean addOrder(Orders order) {
		try {
			ordersRepository.save(order);
			productRepository.deleteById(order.getProductid());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public List<Orders> getOrders(String username){
		Customer cust = customerRepository.findCustomerByCustomername(username);
		System.out.println(cust);
		return ordersRepository.findByCustomer(cust);
	}
}
