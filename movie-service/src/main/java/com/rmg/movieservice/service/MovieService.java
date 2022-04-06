package com.rmg.movieservice.service;

import com.rmg.movieservice.entity.Movie;
import com.rmg.movieservice.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    public List<Movie> getMovies(){
        return movieRepo.findAll();
    }

    public Movie addMovie(Movie movie){
        return movieRepo.save(movie);
    }

    public void clearMovies(){
        movieRepo.deleteAll();
    }

}
