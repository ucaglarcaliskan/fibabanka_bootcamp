package com.example.inventory.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.inventory.data.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
