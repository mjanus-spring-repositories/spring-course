package com.mjanus.springsecurity.exercise.service;

import com.mjanus.springsecurity.exercise.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getMovies();
    void createMovie(Movie movie);
    void deleteMovie(int index);
}