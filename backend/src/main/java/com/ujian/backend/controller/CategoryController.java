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

import com.ujian.backend.entity.Category;
import com.ujian.backend.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//Tampilkan Semua Kategori
	@GetMapping
	public Iterable<Category> getAllCategory(){
		return categoryService.getAllCategory();
	}
	
	//Tampilkan Kategori By ID
	@GetMapping("/{id}")
	public Optional<Category> getCategoryById(@PathVariable int id){
		return categoryService.getCategoryById(id);
	}
	
	//Tambah Kategori
	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	
	//Edit / Update Kategori
	@PutMapping
	public Category updateCategory(@RequestBody Category category) {
		return categoryService.updateCategory(category);
	}
	
	//Hapus Kategori
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
	}	
}
