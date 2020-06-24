package com.ujian.backend.service;

import java.util.Optional;

import com.ujian.backend.entity.Movies;

public interface MovieService {
	public Iterable<Movies> getAllMovies();
	public Optional<Movies> getMoviesById(int id);	
	public Movies addMovies(Movies movies);
	public Movies updateMovies(Movies movies);
	public void deleteMovies(int id);
	public Movies addCategoryToMovie(int movieId, int categoryId);
}
