package basicauth.demo.models;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "card_details")
public class CardDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cardholdername;
	private long cardnumber;
	private int month;
	private int year;
	private int cvv;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "customerid",name="cust_id")
	private Customer customer;

	
	public CardDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CardDetails(int id, String cardholdername, long cardnumber, int cvv,
			Customer customer) {
		super();
		this.id = id;
		this.cardholdername = cardholdername;
		this.cardnumber = cardnumber;
		this.cvv = cvv;
		this.customer = customer;
	}



	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardholdername() {
		return cardholdername;
	}
	public void setCardholdername(String cardholdername) {
		this.cardholdername = cardholdername;
	}
	public long getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(long cardnumber) {
		this.cardnumber = cardnumber;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
