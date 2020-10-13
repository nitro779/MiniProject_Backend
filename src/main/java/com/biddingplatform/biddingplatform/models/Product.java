package com.biddingplatform.biddingplatform.models;

public class Product {

	private int pid;
	private String productname;
	private String description;
	private float initialbid;
	private String image;
	private String category;
	private int seller_id;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String productname, String description, float initialbid, String image, String category,
			int seller_id) {
		super();
		this.pid = pid;
		this.productname = productname;
		this.description = description;
		this.initialbid = initialbid;
		this.image = image;
		this.category = category;
		this.seller_id = seller_id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	public float getInitialbid() {
		return initialbid;
	}
	public void setInitialbid(float initialbid) {
		this.initialbid = initialbid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", productname=" + productname + ", description=" + description + ", initialbid="
				+ initialbid + ", category=" + category + ", seller_id=" + seller_id +", image: "+image +"]";
	}
}
