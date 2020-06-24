package com.ujian.backend.service;

import java.util.Optional;

import com.ujian.backend.entity.Category;

public interface CategoryService {
	public Iterable<Category> getAllCategory();
	public Optional<Category> getCategoryById(int id);	
	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public void deleteCategory(int id);
	public void deleteCategoryFromMovie(int movieId, int categoryId);
}
