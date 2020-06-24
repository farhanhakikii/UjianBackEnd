package com.ujian.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujian.backend.entity.Movies;
import com.ujian.backend.service.CategoryService;
import com.ujian.backend.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	@Autowired
	private CategoryService categoryService;
	
	//Tampilkan Semua Movie
	@GetMapping
	public Iterable<Movies> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	//Tampilkan Movie By ID
	@GetMapping("/{id}")
	public Optional<Movies> getMovieById(@PathVariable int id){
		return movieService.getMoviesById(id);
	}
	
	//Tambah Movie Baru
	@PostMapping
	public Movies addMovie(@RequestBody Movies movies) {
		return movieService.addMovies(movies);
	}
	
	//Edit / Update Movie
	@PutMapping
	public Movies updateMovie(@RequestBody Movies movies) {
		return movieService.updateMovies(movies);
	}
	
	//Menambahkan Kategori ke Movie
	@PutMapping("/{movieId}/category/{categoryId}")
	public Movies addCategoryToMovie(@PathVariable int movieId, @PathVariable int categoryId) {
		return movieService.addCategoryToMovie(movieId, categoryId);
	}
	
	//Delete Movie
	@DeleteMapping("/{movieId}")
	public void deleteMovies(@PathVariable int movieId) {
		movieService.deleteMovies(movieId);
	}

	//Delete Kategori dari Movie
	@DeleteMapping("/{movieId}/category/{categoryId}")
	public void deleteCategoryFromMovie(@PathVariable int movieId, @PathVariable int categoryId) {
		categoryService.deleteCategoryFromMovie(movieId, categoryId);
	}	
}
