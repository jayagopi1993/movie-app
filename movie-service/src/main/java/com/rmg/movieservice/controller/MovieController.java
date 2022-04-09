package com.rmg.movieservice.controller;

import com.rmg.movieservice.entity.Movie;
import com.rmg.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }

    @GetMapping("/{movieId}")
    public Movie getMoviesById(@PathVariable("movieId") String movieId) throws InterruptedException {
        return movieService.getMoviesById(movieId);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @DeleteMapping
    public void clearMovies(){
        movieService.clearMovies();
    }
}
