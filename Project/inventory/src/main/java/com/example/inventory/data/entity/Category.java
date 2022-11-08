package com.example.inventory.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;

	private String categoryName;

	public Category() {
	}

	public Category(long categoryId, String categoryName) {
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
