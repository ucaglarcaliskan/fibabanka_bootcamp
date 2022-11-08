package com.example.commerce.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.commerce.business.dto.CartDto;
import com.example.commerce.business.dto.CartProductDto;
import com.example.commerce.business.dto.CategoryDto;
import com.example.commerce.business.dto.ProductDto;
import com.example.commerce.business.service.CommerceService;

@RestController
@RequestMapping("/commerce")
public class CommerceResource {

	@Autowired
	private CommerceService commerceService;

	@GetMapping("/inventory/categories")
	public List<CategoryDto> findAll() {
		return commerceService.findCategories();
	}

	@GetMapping("/inventory/product/{id}")
	public ProductDto getProduct(@PathVariable("id") long productId) {
		ProductDto productDto = commerceService.findProduct(productId);
		return productDto;
	}

	@GetMapping("/inventory/products/{categoryId}")
	public List<ProductDto> getProducts(@PathVariable("categoryId") long categoryId) {
		List<ProductDto> productDtoList = commerceService.findProductsByCategoryId(categoryId);
		return productDtoList;
	}

	@GetMapping("/shopping/cart/create")
	public long createCart() {
		long cartId = commerceService.createCart();
		return cartId;
	}

	@PostMapping("/shopping/cart/add")
	public void addProductToCart(@RequestBody CartProductDto cartProductDto) {
		System.out.println(cartProductDto);
		commerceService.addProductToCart(cartProductDto);
	}

	@DeleteMapping("/shopping/cart/{cartId}/remove/{productId}")
	public void deleteProductFromCart(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		commerceService.deleteProductFromCart(cartId, productId);
	}

	@GetMapping("/shopping/checkout/{cartId}")
	public void checkout(@PathVariable("cartId") long cartId) {
		commerceService.checkout(cartId);
	}

	@GetMapping("/shopping/cart/find/{cartId}")
	public CartDto findCart(@PathVariable("cartId") long cartId) {
		CartDto cartDto = commerceService.findCart(cartId);
		return cartDto;
	}
}
