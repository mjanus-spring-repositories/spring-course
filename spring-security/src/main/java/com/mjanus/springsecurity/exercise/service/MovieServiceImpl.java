package com.mjanus.springsecurity.exercise.service;

import com.mjanus.springsecurity.exercise.model.Movie;
import com.mjanus.springsecurity.exercise.repository.MovieRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;

    @Override
    public List<Movie> getMovies() {
        return repository.findAll();
    }

    @Override
    public void createMovie(Movie movie) {
        repository.save(movie);
    }

    @Override
    public void deleteMovie(int index) {
        repository.deleteByIndex(index);
    }
}