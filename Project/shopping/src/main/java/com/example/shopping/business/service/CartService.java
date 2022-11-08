package com.example.shopping.business.service;

import com.example.shopping.business.dto.CartDto;

public interface CartService {
	public long createCart();

	public CartDto find(long cartId);

	public void checkoutCart(long cartId);
}
