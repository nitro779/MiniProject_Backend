package basicauth.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "bids_tbl")
public class Bids {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int biddingid;
    private int bidval;
    private String biddername;
    private boolean status=false;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "customerid",name = "cust_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "productId",name = "prod_id")
    private Product product;

    public int getBiddingid() {
        return biddingid;
    }

    public void setBiddingid(int biddingid) {
        this.biddingid = biddingid;
    }

    public double getBidval() {
        return bidval;
    }

    public void setBidval(int bidval) {
        this.bidval = bidval;
    }

    public Bids() {
    }

    public Bids(int biddingid, int bidval) {
        this.biddingid = biddingid;
        this.bidval = bidval;
    }

}
