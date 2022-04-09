package com.rmg.bookingservice.interservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.rmg.bookingservice.dto.Movie;
import com.rmg.bookingservice.dto.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class InterserviceClient {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod="getFallbackRatings")
    public List<Rating> getRatings(String customerId){
        return restTemplate.getForObject("http://RATING-SERVICE/apis/ratings/"+customerId, List.class);
    }

    public List<Rating> getFallbackRatings(String customerId){
        return Arrays.asList(new Rating());
    }

    @HystrixCommand(fallbackMethod="getFallbackMovies")
    public List<Movie> getMovies(){
        return restTemplate.getForObject("http://MOVIE-SERVICE/apis/movies", List.class);
    }

    public List<Movie> getFallbackMovies(){
        return Arrays.asList(new Movie());
    }

    @HystrixCommand(fallbackMethod="getFallbackMoviesById",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
    })
    public Movie getMoviesById(String movieId){
        return restTemplate.getForObject("http://MOVIE-SERVICE/apis/movies"+movieId, Movie.class);
    }

    public Movie getFallbackMoviesById(String movieId){
        return new Movie();
    }

}
