package basicauth.demo.repositories;

import basicauth.demo.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {
    public Seller findSellerBySellername(String seller);
}
