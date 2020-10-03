package basicauth.demo.repositories;

import basicauth.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer findCustomerByCustomername(String customer);
}
