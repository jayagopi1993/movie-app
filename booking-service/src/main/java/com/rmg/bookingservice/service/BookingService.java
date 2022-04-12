package com.rmg.bookingservice.service;

import com.rmg.bookingservice.dto.*;
import com.rmg.bookingservice.interservice.InterserviceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    Environment environment;

    @Value("${sample.response.env}")
    private  String currentEnv;

    @Value("${sample.response.response-type.optional: OPTIONAL RESPONSE}")
    private  String optionalResponseType;

    @Value("${sample.response.movies}")
    private List<String> movies;

    @Value("${sample.response.ratings}")
    private List<String> ratings;

    @Autowired
    private SampleMovie sampleMovie;

    @Autowired
    private InterserviceClient interserviceClient;

    public CustomerRating generateCustomerRatingById(String customerId){
       List<Rating> ratings = interserviceClient.getRatings(customerId);
       System.out.println(ratings);
       List<Movie> movies = interserviceClient.getMovies();
        CustomerRating customerRating = new CustomerRating();
        customerRating.setRatings(ratings);
        customerRating.setMovies(movies);
        return customerRating;
    }

    public Movie generateCustomerMovieById(String movieId){
        Movie movie = interserviceClient.getMoviesById(movieId);
        return movie;
    }

    public SampleCustomerRating generateSampleCustomerRating(){

        SampleCustomerRating sampleCustomerRating = new SampleCustomerRating();
        sampleCustomerRating.setOptionalResponseType(this.optionalResponseType);
        sampleCustomerRating.setMovies(this.movies);
        sampleCustomerRating.setRatings(this.ratings);
        sampleCustomerRating.setCurrentEnv(this.currentEnv);
        sampleCustomerRating.setSampleMovie(this.sampleMovie.toString());

        sampleCustomerRating.setActiveProfile(environment.toString());

        return sampleCustomerRating;
    }
}
