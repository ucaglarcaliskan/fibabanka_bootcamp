package com.example.commerce.business.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.commerce.business.dto.CartDto;
import com.example.commerce.business.dto.CartProductDto;
import com.example.commerce.business.dto.CategoryDto;
import com.example.commerce.business.dto.ProductDto;

@Service
public class CommerceServiceImpl implements CommerceService {

	@Override
	public List<CategoryDto> findCategories() {
		String url = "http://localhost:8081/inventory/categories";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<CategoryDto>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<CategoryDto>>() {
				});
		List<CategoryDto> categoryDtos = response.getBody();
		return categoryDtos;
	}

	@Override
	public List<ProductDto> findProductsByCategoryId(long categoryId) {
		String url = "http://localhost:8081/inventory/products/" + categoryId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<ProductDto>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ProductDto>>() {
				});
		List<ProductDto> productDtos = response.getBody();
		return productDtos;
	}

	@Override
	public ProductDto findProduct(long productId) {
		String url = "http://localhost:8081/inventory/product/" + productId;
		RestTemplate restTemplate = new RestTemplate();
		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
		return productDto;
	}

	@Override
	public long createCart() {
		String url = "http://localhost:8082/shopping/cart/create";
		RestTemplate restTemplate = new RestTemplate();
		long cartId = restTemplate.getForObject(url, Long.class);
		return cartId;

	}

	@Override
	public void addProductToCart(CartProductDto cartProductDto) {
		String url = "http://localhost:8082/shopping/cart/add";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, cartProductDto, ProductDto.class);
	}

	@Override
	public void deleteProductFromCart(long cartId, long productId) {
		String url = "http://localhost:8082/shopping/cart/" + cartId + "/remove/" + productId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
	}

	@Override
	public void checkout(long cartId) {
		String url = "http://localhost:8082/shopping/checkout/" + cartId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(url, Void.class);
	}

	@Override
	public CartDto findCart(long cartId) {
		String url = "http://localhost:8082/shopping/cart/find/" + cartId;
		RestTemplate restTemplate = new RestTemplate();
		CartDto cartDto = restTemplate.getForObject(url, CartDto.class);
		for (CartProductDto cartProductDto : cartDto.getCartProducts()) {
			ProductDto productDto = findProduct(cartProductDto.getProductId());
			if (productDto != null)
				cartProductDto.setProductName(productDto.getProductName());
		}
		return cartDto;
	}

}
