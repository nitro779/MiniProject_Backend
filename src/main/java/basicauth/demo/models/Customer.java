package basicauth.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_tbl")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerid;

    private String customername;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Bids> bids = new ArrayList<>();

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CardDetails> cards = new ArrayList<CardDetails>();
    
    @OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Orders> orders = new ArrayList<Orders>();
    
    public List<CardDetails> getCards() {
		return cards;
	}

	public void setCards(List<CardDetails> cards) {
		this.cards = cards;
	}

	public Customer() {
    }

    @JsonIgnore
    public List<Bids> getBids() {
        return bids;
    }

    @JsonIgnore
    public void setBids(List<Bids> bids) {
        this.bids = bids;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public Customer(int customerid, String customername) {
        this.customerid = customerid;
        this.customername = customername;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerid=" + customerid +
                ", customername='" + customername + '\'' +
                ", bids=" + bids +
                '}';
    }
}
