package com.example.commerce.business.dto;

import java.util.List;

public class CartDto {

	private long cartId;
	private String customerName;
	private List<CartProductDto> cartProducts;

	public CartDto() {
	}

	public CartDto(long cartId, String customerName, List<CartProductDto> cartProducts) {
		this.cartId = cartId;
		this.customerName = customerName;
		this.cartProducts = cartProducts;
	}

	public long getCartId() {
		return cartId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public List<CartProductDto> getCartProducts() {
		return cartProducts;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCartProducts(List<CartProductDto> cartProducts) {
		this.cartProducts = cartProducts;
	}

	@Override
	public String toString() {
		return "cartId=" + cartId + " customerName=" + customerName + " <br><u>Sepetteki Ürünler</u><br>" + cartProducts
				+ "]";
	}

}
