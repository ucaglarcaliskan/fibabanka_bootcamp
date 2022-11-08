package com.example.shopping.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.shopping.data.entity.CartProduct;

public interface CartProductRepository extends CrudRepository<CartProduct, Long> {

	@Query("DELETE FROM CartProduct WHERE cartId = :cartId AND productId = :productId")
	public void deleteProduct(@Param("cartId") long cartId, @Param("productId") long productId);

	@Transactional
	public void deleteByCartIdAndProductId(long cartId, long productId);

	@Query("SELECT cp FROM CartProduct as cp WHERE cp.cartId = :cartId")
	public List<CartProduct> findByCartId(@Param("cartId") long cartId);
}
