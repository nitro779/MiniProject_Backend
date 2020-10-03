package basicauth.demo.repositories;

import basicauth.demo.models.Bids;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidsRepository extends JpaRepository<Bids,Integer> {
    public List<Bids> findAllByBiddername(String biddername);

    public List<Bids> findBidsByProduct_ProductId(int productId);

    public Bids findBidsByProduct_ProductIdAndBiddername(int productId,String biddername);

}
