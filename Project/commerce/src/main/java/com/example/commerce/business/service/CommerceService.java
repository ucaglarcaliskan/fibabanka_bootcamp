package com.example.commerce.business.service;

import java.util.List;

import com.example.commerce.business.dto.CartDto;
import com.example.commerce.business.dto.CartProductDto;
import com.example.commerce.business.dto.CategoryDto;
import com.example.commerce.business.dto.ProductDto;

public interface CommerceService {

	public List<CategoryDto> findCategories();

	public List<ProductDto> findProductsByCategoryId(long categoryId);

	public ProductDto findProduct(long productId);

	public long createCart();

	public void addProductToCart(CartProductDto cartProductDto);

	public void deleteProductFromCart(long cartId, long productId);

	public void checkout(long cartId);

	public CartDto findCart(long cartId);
}
