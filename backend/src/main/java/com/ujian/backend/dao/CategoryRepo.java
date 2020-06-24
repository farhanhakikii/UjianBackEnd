package com.ujian.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian.backend.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
