package basicauth.demo.services;

import basicauth.demo.models.Bids;
import basicauth.demo.models.Customer;
import basicauth.demo.models.Seller;
import basicauth.demo.repositories.BidsRepository;
import basicauth.demo.repositories.CustomerRepository;
import basicauth.demo.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class BidsService {

    @Autowired
    private BidsRepository bidsRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    public boolean addBid(Bids bid){
        try {
            System.out.println(bid.getBiddername());
            Customer cust = customerRepository.findCustomerByCustomername(bid.getBiddername());
            if(cust==null){
                cust = new Customer();
            }
            cust.setCustomername(bid.getBiddername());
            Bids existinBid = bidsRepository.findBidsByProduct_ProductIdAndBiddername(bid.getProduct().getProduct_id(),bid.getBiddername());
            if(existinBid==null){
                cust.getBids().add(bid);
                bid.setCustomer(cust);
                bid.setProduct(bid.getProduct());
                bid.getProduct().getBids().add(bid);
                Seller seller = bid.getProduct().getSeller();
                sellerRepository.save(seller);
                customerRepository.save(cust);
            }else{
                existinBid.setBidval((int) bid.getBidval());
                customerRepository.save(cust);
                System.out.println("Entered into already existing block ");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public List<Bids> getMyBids(String bidder){

        List<Bids> bids =  bidsRepository.findAllByBiddername(bidder);
        return bids;
    }

    public List<Bids> getBidsByProductsId(int id) {
        return bidsRepository.findBidsByProduct_ProductId(id);
    }

    public Bids getBidById(int id){
        Optional<Bids> myBid =  bidsRepository.findById(id);
        if (myBid.isPresent()){
            return myBid.get();
        }
        return null;
    }

    public void acceptBid(Bids bids){
        bids.setStatus(true);
        this.bidsRepository.save(bids);
    }
}
