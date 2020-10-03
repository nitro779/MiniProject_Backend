package basicauth.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seller_tbl")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerid;
    @Column(unique = true)
    private String sellername;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products = new ArrayList<>();
    
    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Orders> orders = new ArrayList<>();

    public Seller() {
    }

    public Seller(String seller) {
        this.sellername = seller;
        this.products = new ArrayList<>();
    }

    public Seller(Long sellerid, String sellername, List<Product> products) {
        this.sellerid = sellerid;
        this.sellername = sellername;
        this.products = products;
    }

    public Long getSellerid() {
        return sellerid;
    }

    public void setSellerid(Long sellerid) {
        this.sellerid = sellerid;
    }

    public String getSellername() {
        return sellername;
    }

    public void setSellername(String sellername) {
        this.sellername = sellername;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
