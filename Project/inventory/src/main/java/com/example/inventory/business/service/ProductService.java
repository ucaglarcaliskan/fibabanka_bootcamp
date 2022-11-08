package com.example.inventory.business.service;

import java.util.List;

import com.example.inventory.business.dto.ProductDto;

public interface ProductService {
	public List<ProductDto> findProductsByCategoryId(long categoryId);
	
	public ProductDto find(long productId);
}
