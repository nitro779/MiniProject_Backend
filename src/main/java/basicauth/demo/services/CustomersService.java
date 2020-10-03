package basicauth.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basicauth.demo.models.Customer;
import basicauth.demo.repositories.CustomerRepository;

@Service
public class CustomersService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer getCustomerByName(String customer) {
		return customerRepository.findCustomerByCustomername(customer);
	}
}
