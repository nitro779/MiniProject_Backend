package basicauth.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import basicauth.demo.models.Customer;
import basicauth.demo.models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	public List<Orders> findByCustomer(Customer customer);
}
