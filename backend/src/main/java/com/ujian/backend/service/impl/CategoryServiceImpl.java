package com.ujian.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujian.backend.dao.CategoryRepo;
import com.ujian.backend.dao.MovieRepo;
import com.ujian.backend.entity.Category;
import com.ujian.backend.entity.Movies;
import com.ujian.backend.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public Iterable<Category> getAllCategory() {
		return categoryRepo.findAll();
	}

	@Override
	public Optional<Category> getCategoryById(int id) {
		return categoryRepo.findById(id);
	}

	@Override
	public Category addCategory(Category category) {
		category.setCategoryId(0);
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public void deleteCategory(int id) {
		Category findCategory = categoryRepo.findById(id).get();
		
		findCategory.getMovies().forEach(movie -> {
			List<Category> movieCategory = movie.getCategory();
			movieCategory.remove(findCategory);
			movieRepo.save(movie);
		});
		
		findCategory.setMovies(null);

		categoryRepo.deleteById(id);
	}

	@Override
	public void deleteCategoryFromMovie(int movieId, int categoryId) {
		Category findCategory = categoryRepo.findById(categoryId).get();
		Movies findMovie = movieRepo.findById(movieId).get();

		List<Category> category = findMovie.getCategory();
		category.remove(findCategory);
		movieRepo.save(findMovie);
	}

}
