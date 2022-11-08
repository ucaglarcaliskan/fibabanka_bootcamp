package com.example.shopping.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.shopping.data.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {

}
