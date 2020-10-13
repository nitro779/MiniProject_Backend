package com.biddingplatform.biddingplatform.models;

import java.sql.Date;

public class Order {
	private int order_id;
	private Date order_date;
	private int product_id;
	private String product_name;
	private String product_image;
	private String category;
	private float price;
	private int customer_id;
	private int seller_id;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int order_id, Date order_date,int product_id, String product_name, String product_image, String category, float price,
			int customer_id, int seller_id) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.product_name = product_name;
		this.product_image = product_image;
		this.category = category;
		this.price = price;
		this.customer_id = customer_id;
		this.seller_id = seller_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	
}
