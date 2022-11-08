package com.example.inventory.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.business.dto.ProductDto;
import com.example.inventory.business.service.ProductService;


@RestController
@RequestMapping("/inventory")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@GetMapping("/product/{id}")
	public ProductDto getProduct(@PathVariable("id") long productId) {
		ProductDto productDto = productService.find(productId);
		return productDto;
	}
	
	@GetMapping("/products/{categoryId}")
	public List<ProductDto> getProducts(@PathVariable("categoryId") long categoryId) {
		List<ProductDto> productDtoList = productService.findProductsByCategoryId(categoryId);
		return productDtoList;
	}
}
