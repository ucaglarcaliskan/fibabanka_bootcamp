package com.example.shopping.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartProductId;

	private long cartId;
	private long productId;
	private long salesQuantity;
	private double salesPrice;
	private double lineAmount;

	public CartProduct() {
	}

	public CartProduct(long cartProductId, long cartId, long productId, long salesQuantity, double salesPrice) {
		this.cartProductId = cartProductId;
		this.cartId = cartId;
		this.productId = productId;
		this.salesQuantity = salesQuantity;
		this.salesPrice = salesPrice;
		this.lineAmount = salesQuantity * salesPrice;
	}

	public CartProduct(long cartProductId, long cartId, long productId, long salesQuantity, double salesPrice,
			double lineAmount) {
		this.cartProductId = cartProductId;
		this.cartId = cartId;
		this.productId = productId;
		this.salesQuantity = salesQuantity;
		this.salesPrice = salesPrice;
		this.lineAmount = lineAmount;
	}

	public long getCartProductId() {
		return cartProductId;
	}

	public long getCartId() {
		return cartId;
	}

	public long getProductId() {
		return productId;
	}

	public long getSalesQuantity() {
		return salesQuantity;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public double getLineAmount() {
		return lineAmount;
	}

	public void setCartProductId(long cartProductId) {
		this.cartProductId = cartProductId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public void setSalesQuantity(long salesQuantity) {
		this.salesQuantity = salesQuantity;
		this.lineAmount = salesQuantity * salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
		this.lineAmount = salesQuantity * salesPrice;
	}

	public void setLineAmount(double lineAmount) {
		this.lineAmount = lineAmount;
	}

}
