package basicauth.demo.repositories;

import basicauth.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    //public List<Product> findByselleridNotEquals(String sellerid);
    public List<Product> findProductBySellerSellername(String sellername);
    public List<Product> findProductBySellerSellernameNotContaining(String sellername);
    public Product findProductByproductId(int productId);
}
