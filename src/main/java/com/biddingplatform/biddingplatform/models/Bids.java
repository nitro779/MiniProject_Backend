package com.biddingplatform.biddingplatform.models;

public class Bids {
	
	private int bid_id;
	private float bidval;
	private int product_id;
	private int customer_id;
	private int status;
	
	
	public Bids() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Bids(int bid_id, float bidval, int product_id, int customer_id, int status) {
		super();
		this.bid_id = bid_id;
		this.bidval = bidval;
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.status = status;
	}
	
	
	public int getBid_id() {
		return bid_id;
	}


	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}


	public float getBidval() {
		return bidval;
	}


	public void setBidval(float bidval) {
		this.bidval = bidval;
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public int getStatus() {
		return this.status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Bids [bid_id=" + bid_id + ", bid_val=" + bidval + ", prod_id=" + product_id + ", cust_id=" + customer_id
				+ ", status=" + status + "]";
	}
	
	
	
}
