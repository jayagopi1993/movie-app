package com.rmg.movieservice.service;

import com.rmg.movieservice.entity.Movie;
import com.rmg.movieservice.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    public static int counter = 1;

    public List<Movie> getMovies(){
        return movieRepo.findAll();
    }

    public Movie getMoviesById(String movieId) throws InterruptedException {
        if(counter%2==0){
            System.out.println("counter running...."+counter);
            Thread.sleep(3000);
        }
        counter ++;
        return movieRepo.findById(movieId).orElse(new Movie());
    }

    public Movie addMovie(Movie movie){
        return movieRepo.save(movie);
    }

    public void clearMovies(){
        movieRepo.deleteAll();
    }

}
