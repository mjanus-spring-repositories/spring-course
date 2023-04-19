package com.mjanus.springsecurity.exercise.repository;

import com.mjanus.springsecurity.exercise.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMovieRepository implements MovieRepository {

    private List<Movie> movies = new ArrayList<>();

    @Override
    public List<Movie> findAll() {
        return movies;
    }

    @Override
    public void save(Movie movie) {
        movies.add(movie);
    }

    @Override
    public void deleteByIndex(int index) {
        movies.remove(index);
    }

}