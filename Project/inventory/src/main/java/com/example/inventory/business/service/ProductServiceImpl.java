package com.example.inventory.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.inventory.business.dto.ProductDto;
import com.example.inventory.data.entity.Product;
import com.example.inventory.data.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<ProductDto> findProductsByCategoryId(long categoryId) {
		List<Product> productList = productRepository
				.findProductsByCategoryId(categoryId);
		List<ProductDto> productDtoList = new ArrayList<>();
		for (Product product : productList) {
			productDtoList.add(toDto(product));
		}
		return productDtoList;
	}

	@Override
	public ProductDto find(long productId) {
		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent()) {
			Product product = optional.get();
			ProductDto productDto = toDto(product);
			return productDto;
		}
		return null;
		// TODO null check
	}

	private ProductDto toDto(Product product) {
		return new ProductDto(product.getProductId(), product.getProductName(),
				product.getSalesPrice(), product.getCategoryId());
	}
}
