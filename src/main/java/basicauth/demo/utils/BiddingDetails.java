package basicauth.demo.utils;

import basicauth.demo.models.Product;
import org.springframework.stereotype.Component;

@Component
public class BiddingDetails {

    private Product product;
    private int bidval;
    private String biddername;

    public String getBiddername() {
        return biddername;
    }

    public void setBiddername(String biddername) {
        this.biddername = biddername;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getBidval() {
        return bidval;
    }

    public void setBidVal(int bidval) {
        this.bidval = bidval;
    }

    public BiddingDetails(Product product, int bidVal) {
        this.product = product;
        this.bidval = bidVal;
    }

    public BiddingDetails() {
    }
}
