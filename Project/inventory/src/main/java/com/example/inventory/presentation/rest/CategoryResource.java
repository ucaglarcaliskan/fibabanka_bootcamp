package com.example.inventory.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.business.dto.CategoryDto;
import com.example.inventory.business.service.CategoryService;

@RestController
@RequestMapping("/inventory")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/categories")
	public List<CategoryDto> findAll() {
		return categoryService.getCategories();
	}
}
