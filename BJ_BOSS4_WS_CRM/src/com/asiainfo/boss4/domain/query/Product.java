package com.asiainfo.boss4.domain.query;

public class Product {
	// Fields

	private String prodId;
	private String prodName;
	
	// Constructors

	/** default constructor */
	public Product() {
	}

	public Product(String prodId, String prodName) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
}
