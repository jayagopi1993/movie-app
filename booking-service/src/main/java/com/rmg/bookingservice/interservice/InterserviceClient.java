package com.rmg.bookingservice.interservice;

import com.rmg.bookingservice.dto.Movie;
import com.rmg.bookingservice.dto.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class InterserviceClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<Rating> getRatings(String customerId){
        return restTemplate.getForObject("http://rating-service/apis/ratings/"+customerId, List.class);
    }

    public List<Movie> getMovies(){
        return restTemplate.getForObject("http://movie-service/apis/movies", List.class);
    }

}
