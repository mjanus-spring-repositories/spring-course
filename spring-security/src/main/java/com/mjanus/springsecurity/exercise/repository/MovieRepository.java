package com.mjanus.springsecurity.exercise.repository;

import com.mjanus.springsecurity.exercise.model.Movie;

import java.util.List;


public interface MovieRepository {

    List<Movie> findAll();
    void save(Movie movie);
    void deleteByIndex(int index);

}