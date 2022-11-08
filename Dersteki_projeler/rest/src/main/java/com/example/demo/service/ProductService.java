package com.example.demo.service;

import java.util.List;

import com.example.demo.Product;

public interface ProductService {
	Product find(long productId);
	
	List<Product> findAll();
	
	public void createProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(long productId);
}
