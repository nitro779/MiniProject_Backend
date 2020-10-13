package com.biddingplatform.biddingplatform.models;

public class CardDetails {

	private int card_id;
	private String cardholder;
	private long cardnumber;
	private int month;
	private int year;
	private int customer_id;
	private int cvv;
	public CardDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CardDetails(int card_id, String cardholer, long card_number, int month, int year, int customer_id,int cvv) {
		super();
		this.card_id = card_id;
		this.cardholder = cardholer;
		this.cardnumber = card_number;
		this.month = month;
		this.year = year;
		this.customer_id = customer_id;
		this.cvv = cvv;
	}
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public String getCardholder() {
		return cardholder;
	}
	public void setCardholder(String cardholer) {
		this.cardholder = cardholer;
	}
	public long getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(long cardnumber) {
		this.cardnumber = cardnumber;
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
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "CardDetails [card_id=" + card_id + ", cardholer=" + cardholder + ", card_number=" + cardnumber
				+ ", month=" + month + ", year=" + year + ", customer_id=" + customer_id + ", cvv=" + cvv +"]";
	}
	
	
}
