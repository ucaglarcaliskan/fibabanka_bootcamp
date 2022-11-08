package com.example.commerce.presentation.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.commerce.business.dto.CartProductDto;
import com.example.commerce.business.dto.CategoryDto;
import com.example.commerce.business.dto.ProductDto;

@Controller
@ResponseBody
@RequestMapping("/test/commerce")
public class CommerceController {

	@GetMapping("/inventory/categories")
	public String findCategories() {
		String url = "http://localhost:8080/commerce/inventory/categories";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<CategoryDto>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<CategoryDto>>() {
				});
		List<CategoryDto> categoryDtos = response.getBody();
		return "Kategoriler Getirildi: " + categoryDtos;

	}

	@GetMapping("/inventory/productsByCategory")
	public String findProductsByCategoryId(@PathVariable("categoryId") long categoryId) {
		String url = "http://localhost:8080/commerce/inventory/products/" + categoryId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<ProductDto>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ProductDto>>() {
				});
		List<ProductDto> productDtos = response.getBody();
		return "Kategoriye Göre Ürünler Getirildi: " + productDtos;

	}

	@GetMapping("/shopping/cart/add")
	public String addProductToCart() {
		CartProductDto cartProductDto = new CartProductDto(0, 2, 1, 1, 11200, 11200);
		String url = "http://localhost:8080/commerce/shopping/cart/add";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, cartProductDto, ProductDto.class);
		return "Sepete Ürün Eklendi: " + cartProductDto;
	}

	@GetMapping("/shopping/cart/removeProduct")
	public String deleteProductFromCart() {
		String url = "http://localhost:8080/commerce/shopping/cart/2/remove/1";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Ürün Sepetten Silindi";
	}

	@GetMapping("/shopping/checkout")
	public String checkout() {
		String url = "http://localhost:8080/commerce/shopping/checkout/2";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(url, Void.class);
		return "Sepet Ödenerek Bitirildi.";
	}
}
