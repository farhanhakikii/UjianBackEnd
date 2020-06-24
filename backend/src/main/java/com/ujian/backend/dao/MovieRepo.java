package com.ujian.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian.backend.entity.Movies;

public interface MovieRepo extends JpaRepository<Movies, Integer>{
	//public Movies findByMovieName(String movieName);
}
