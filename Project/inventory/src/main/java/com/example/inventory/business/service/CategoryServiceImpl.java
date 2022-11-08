package com.example.inventory.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.inventory.business.dto.CategoryDto;
import com.example.inventory.data.entity.Category;
import com.example.inventory.data.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryDto> getCategories() {
		Iterable<Category> iterable = categoryRepository.findAll();
		List<CategoryDto> categoryDtoList = new ArrayList<>();
		for (Category category : iterable) {
			categoryDtoList.add(new CategoryDto(category.getCategoryId(), category.getCategoryName()));
		}
		return categoryDtoList;
	}

}
