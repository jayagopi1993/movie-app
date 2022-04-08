package com.rmg.bookingservice.service;

import com.rmg.bookingservice.dto.CustomerRating;
import com.rmg.bookingservice.dto.Movie;
import com.rmg.bookingservice.dto.Rating;
import com.rmg.bookingservice.interservice.InterserviceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

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



}
