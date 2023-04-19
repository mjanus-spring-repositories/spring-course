package com.mjanus.springsecurity.exercise.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RepositoryConfiguration {

    @Bean
    MovieRepository repository() {
        return new InMemoryMovieRepository();
    }

}