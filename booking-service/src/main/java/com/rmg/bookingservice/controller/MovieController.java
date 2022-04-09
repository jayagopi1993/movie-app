package com.rmg.bookingservice.controller;

import com.rmg.bookingservice.dto.CustomerRating;
import com.rmg.bookingservice.dto.Movie;
import com.rmg.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/customer-movies")
public class MovieController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/{movieId}")
    public Movie getCustomerMovies(@PathVariable("movieId") String movieId){
        return bookingService.generateCustomerMovieById(movieId);
    }

}
