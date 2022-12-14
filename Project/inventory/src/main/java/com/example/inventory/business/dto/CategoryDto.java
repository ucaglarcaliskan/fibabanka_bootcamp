package com.example.inventory.business.dto;

public class CategoryDto {
	
	private long categoryId;

	private String categoryName;

	public CategoryDto() {
	}

	public CategoryDto(long categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
