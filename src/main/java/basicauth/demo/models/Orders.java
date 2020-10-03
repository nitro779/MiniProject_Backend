package basicauth.demo.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders_tbl")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date order_date;
	private int price;
	public int getBidding_id() {
		return bidding_id;
	}



	public void setBidding_id(int bidding_id) {
		this.bidding_id = bidding_id;
	}
	private int bidding_id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "customerid",name="cust_id")
	private Customer customer;
	
	private int productid;
	public int getProductid() {
		return productid;
	}



	public void setProductid(int productid) {
		this.productid = productid;
	}
	private String productname;
	private String category;
	private String description;
	private String imageurl;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "sellerid",name="seller_id")
	private Seller seller;
	
	
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Orders(long id, Date order_date, int price, int bidding_id, Customer customer, String productname,
			String description, String imageUrl, Seller sellerr) {
		super();
		this.id = id;
		this.order_date = order_date;
		this.price = price;
		this.bidding_id = bidding_id;
		this.customer = customer;
		this.productname = productname;
		this.description = description;
		this.imageurl = imageUrl;
		this.seller = sellerr;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Date getOrder_date() {
		return order_date;
	}



	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public String getProductname() {
		return productname;
	}



	public void setProductname(String productname) {
		this.productname = productname;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getImageurl() {
		return imageurl;
	}



	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}



	public Seller getSeller() {
		return seller;
	}



	public void setSeller(Seller seller) {
		this.seller = seller;
	}



	@Override
	public String toString() {
		return "Orders [id=" + id + ", order_date=" + order_date + ", price=" + price + ", bidding_id=" + bidding_id
				+ ", customer=" + customer + ", productname=" + productname + ", description=" + description
				+ ", imageurl=" + imageurl + ", seller=" + seller +", category"+category+ "]";
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
