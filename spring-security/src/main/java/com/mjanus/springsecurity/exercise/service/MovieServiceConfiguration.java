package com.mjanus.springsecurity.exercise.service;

import com.mjanus.springsecurity.exercise.repository.MovieRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MovieServiceConfiguration {

    @Bean
    MovieService movieService(MovieRepository repository) {
        return new MovieServiceImpl(repository);
    }

}