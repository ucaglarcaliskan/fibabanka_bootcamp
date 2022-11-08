package com.example.commerce.presentation.mvc;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.commerce.business.dto.CartDto;
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
		return "Kategoriler Getirildi: <br>" + categoryDtos;

	}

	@GetMapping("/inventory/productsByCategory")
	public String findProductsByCategoryId() {
		String url = "http://localhost:8080/commerce/inventory/products/1";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<ProductDto>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ProductDto>>() {
				});
		List<ProductDto> productDtos = response.getBody();
		return "Kategoriye Göre Ürünler Getirildi: <br>" + productDtos;

	}

	@GetMapping("/inventory/product")
	public String findProduct() {
		String url = "http://localhost:8080/commerce/inventory/product/2";
		RestTemplate restTemplate = new RestTemplate();
		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
		return "Ürün getirildi: <br>" + productDto;
	}

	@GetMapping("/shopping/cart/create")
	public String createCart() {
		String url = "http://localhost:8080/commerce/shopping/cart/create";
		RestTemplate restTemplate = new RestTemplate();
		long cartId = restTemplate.getForObject(url, Long.class);
		return "Sepet oluşturuldu. Sepet ID: " + cartId;
	}

	@GetMapping("/shopping/cart/add")
	public String addProductToCart() {
		CartProductDto cartProductDto = new CartProductDto(0, 3, 2, 1, 17000, 17000);
		String url = "http://localhost:8080/commerce/shopping/cart/add";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, cartProductDto, ProductDto.class);
		return "Sepete Ürün Eklendi: <br>" + cartProductDto;
	}

	@GetMapping("/shopping/cart/removeProduct")
	public String deleteProductFromCart() {
		String url = "http://localhost:8080/commerce/shopping/cart/3/remove/2";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Ürün Sepetten Silindi";
	}

	@GetMapping("/shopping/checkout")
	public String checkout() {
		long cartId = 3;
		String url = "http://localhost:8080/commerce/shopping/checkout/" + cartId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(url, Void.class);
		return "Sepet Ödenerek Bitirildi. Id: " + cartId;
	}

	@GetMapping("/shopping/cart/find")
	public String findCart() {
		String url = "http://localhost:8080/commerce/shopping/cart/find/3";
		RestTemplate restTemplate = new RestTemplate();
		CartDto cartDto = restTemplate.getForObject(url, CartDto.class);

		return "Sepet detayı: <br>" + cartDto;
	}
}
