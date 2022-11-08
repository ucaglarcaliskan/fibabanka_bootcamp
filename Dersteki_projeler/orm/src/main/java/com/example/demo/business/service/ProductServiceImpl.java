 package com.example.demo.business.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.business.dto.ProductDto;
import com.example.demo.data.entity.Product;
import com.example.demo.data.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	@Override
	public long create(ProductDto productDto) {
		Product product = new Product();
		product.setProductName(productDto.getProductName());
		product.setSalesPrice(productDto.getSalesPrice());
		productRepository.save(product);
		return product.getProductId();
	}

	@Override
	public void update(ProductDto productDto) {
	}

	@Override
	public ProductDto find(long productId) {
		return null;
	}

	@Override
	public List<ProductDto> findAll() {
		return null;
	}

}
