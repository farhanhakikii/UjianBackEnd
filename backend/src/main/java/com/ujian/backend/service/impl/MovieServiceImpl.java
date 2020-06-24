package com.ujian.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujian.backend.dao.CategoryRepo;
import com.ujian.backend.dao.MovieRepo;
import com.ujian.backend.entity.Category;
import com.ujian.backend.entity.Movies;
import com.ujian.backend.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepo movieRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Iterable<Movies> getAllMovies() {
		return movieRepo.findAll();
	}

	@Override
	public Optional<Movies> getMoviesById(int id) {
		return movieRepo.findById(id);
	}

	@Override
	public Movies addMovies(Movies movies) {
		movies.setMovieId(0);
		return movieRepo.save(movies);
	}

	@Override
	public Movies updateMovies(Movies movies) {
		return movieRepo.save(movies);
	}

	@Override
	public void deleteMovies(int id) {
		Movies findMovie = movieRepo.findById(id).get();

		findMovie.getCategory().forEach(category -> {
			List<Movies> movie = category.getMovies();
			movie.remove(findMovie);
			categoryRepo.save(category);
		});
		
		findMovie.setCategory(null);
		
		movieRepo.deleteById(id);
	}

	@Override
	public Movies addCategoryToMovie(int movieId, int categoryId) {
		Movies findMovie = movieRepo.findById(movieId).get();
		Category findCategory = categoryRepo.findById(categoryId).get();
		findMovie.getCategory().add(findCategory);
		
		return movieRepo.save(findMovie);
	}
}
