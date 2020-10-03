package basicauth.demo.models;

import basicauth.demo.utils.ProductDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products_tbl")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(nullable = false)
    private String productname;
    @Column(nullable = false)
    private String category;
    private String description;
    private int initialbid;
    private String imageurl;

    public Product(){

    }
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Bids> bids= new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "sellerid",name = "seller_id")
    private Seller seller;

    public List<Bids> getBids() {
        return bids;
    }

    public void setBids(List<Bids> bidsList) {
        this.bids = bidsList;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product(int product_id, String productname, String category, String description, int initialbid, String imageurl) {
        this.productId = product_id;
        this.productname = productname;
        this.category = category;
        this.description = description;
        this.initialbid = initialbid;
        this.imageurl = imageurl;
    }

    public Product(ProductDetails productDetails) {
        this.productname = productDetails.getProductname();
        this.category = productDetails.getCategory();
        this.description = productDetails.getDescription();
        this.initialbid = productDetails.getInitialbid();
        this.imageurl = productDetails.getImageurl();
        this.setSeller(new Seller(productDetails.getSellerid()));
    }

    public int getProduct_id() {
        return productId;
    }

    public void setProduct_id(int product_id) {
        this.productId = product_id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInitialbid() {
        return initialbid;
    }

    public void setInitialbid(int initialbid) {
        this.initialbid = initialbid;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productname='" + productname + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", initialbid=" + initialbid +
                ", imageurl='" + imageurl + '\'' +
                ", bids=" + bids +
                ", seller=" + seller +
                '}';
    }
}
