package basicauth.demo.controller;

import basicauth.demo.models.Bids;
import basicauth.demo.models.Customer;
import basicauth.demo.services.BidsService;
import basicauth.demo.utils.BiddingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BidsController {

    @Autowired
    private BidsService bidsService;


    @PostMapping("/bids")
    public boolean addBid(@RequestBody BiddingDetails biddingDetails){
        Bids bid = new Bids();
        bid.setBidval((int) biddingDetails.getBidval());
        bid.setBiddername(biddingDetails.getBiddername());
        bid.setProduct(biddingDetails.getProduct());
        return bidsService.addBid(bid);
    }

    @GetMapping("/mybids/{name}")
    public List<Bids> findMyBids(@PathVariable("name") String username){
        for (Bids bid:bidsService.getMyBids(username)) {
            System.out.println(bid.getProduct());
        }
        return bidsService.getMyBids(username);
    }

    @GetMapping("bids/product/{id}")
    public List<Bids> findByProductId(@PathVariable("id") Integer productId){
        return bidsService.getBidsByProductsId(productId);
    }

    @GetMapping("bids/bid/{id}")
    public Bids getBidById(@PathVariable("id") int id){
        return bidsService.getBidById(id);
    }
}
