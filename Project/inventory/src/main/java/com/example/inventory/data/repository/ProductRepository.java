package com.example.inventory.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.inventory.data.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query("select p from Product as p where p.categoryId = :catId")
	public List<Product> findProductsByCategoryId(@Param("catId") long categoryId);
}
