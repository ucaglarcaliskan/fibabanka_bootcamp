package com.example.demo.business.dto;

public class ProductDto {

	private long productId;

	private String productName;

	private double salesPrice;

	public long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getSalesPrice() {
		return salesPrice;
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

}
