package com.mjanus.springsecurity.exercise.mapper;

import com.mjanus.springsecurity.exercise.model.Movie;
import com.mjanus.springsecurity.exercise.model.MovieDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class MovieMapper {

    public static Movie toBook(MovieDto movieDto) {
        return Movie.of(movieDto.getTitle(), movieDto.getAuthor(), movieDto.getYear());
    }

    public static MovieDto toBookDto(Movie movie) {
        return new MovieDto(movie.getTitle(), movie.getAuthor(), movie.getYear());
    }

    public static List<Movie> toBookList(List<MovieDto> movieDtos) {
        return movieDtos
                .stream()
                .map(bdto -> Movie.of(bdto.getTitle(), bdto.getAuthor(), bdto.getYear()))
                .collect(toList());
    }

    public static List<MovieDto> toBookDtoList(List<Movie> movies) {
        return movies
                .stream()
                .map(b -> new MovieDto(b.getTitle(), b.getAuthor(), b.getYear()))
                .collect(toList());
    }

}