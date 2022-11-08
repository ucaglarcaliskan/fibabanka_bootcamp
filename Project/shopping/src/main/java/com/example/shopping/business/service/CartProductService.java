package com.example.shopping.business.service;

import com.example.shopping.business.dto.CartProductDto;
import com.example.shopping.data.entity.CartProduct;

public interface CartProductService {

	public void deleteProduct(long cartId, long productId);

	public void addCartProduct(CartProductDto cartProductDto);

	public CartProduct toEntity(CartProductDto cartProductDto);

	public CartProductDto toDto(CartProduct cartProduct);
}
