package com.example.inventory.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;

	private String productName;

	private double salesPrice;

	private long categoryId;

	public Product() {
	}

	public Product(long productId, String productName, double salesPrice,
			long categoryId) {
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
		this.categoryId = categoryId;
	}

	public long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

}
