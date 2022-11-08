package com.example.demo.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.data.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	@Query("select p from Product as p where p.salesPrice >= :minPrice")
	List<Product> findBySalesPriceMin(@Param("minPrice") double minimumPrice);
}
