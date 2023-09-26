package com.ravi.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.watchlist.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie,Integer> {

}
