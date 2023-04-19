package com.mjanus.springsecurity.exercise.controller;

import com.mjanus.springsecurity.exercise.mapper.MovieMapper;
import com.mjanus.springsecurity.exercise.model.MovieDto;
import com.mjanus.springsecurity.exercise.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movie")
class MovieController {

    private final MovieService service;

    @GetMapping
    public List<MovieDto> getBooks() {
        return MovieMapper.toBookDtoList(service.getMovies());
    }

    @PostMapping
    public void createBook(@RequestBody MovieDto movieDto) {
        service.createMovie(MovieMapper.toBook(movieDto));
    }

    @DeleteMapping(path = "/{index}")
    public void deleteBook(@PathVariable("index") int index) {
        service.deleteMovie(index);
    }
}