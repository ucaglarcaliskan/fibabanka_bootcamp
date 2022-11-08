package com.example.commerce.business.dto;

public class CartProductDto {

	private long cartProductId;
	private long cartId;
	private long productId;
	private long salesQuantity;
	private double salesPrice;
	private double lineAmount;
	private String productName;

	public CartProductDto() {
	}

	public CartProductDto(long cartProductId, long cartId, long productId, long salesQuantity, double salesPrice,
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
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public void setLineAmount(double lineAmount) {
		this.lineAmount = lineAmount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
//		return "[cartId=" + cartId + ", productId=" + productId + ", salesQuantity=" + salesQuantity + ", salesPrice="
//				+ salesPrice + ", lineAmount=" + lineAmount + ", productName=" + productName + "]";
		return "Ürün Adı: " + productName + "<br>Adet: " + salesQuantity + "<br>Adet Fiyatı: " + salesPrice
				+ "<br>Toplam: " + lineAmount;
	}

}
