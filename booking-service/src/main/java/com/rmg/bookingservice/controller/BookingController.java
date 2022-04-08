package com.rmg.bookingservice.controller;

import com.rmg.bookingservice.dto.CustomerRating;
import com.rmg.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apis/customer-ratings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/{customerId}")
    public CustomerRating getCustomerRatings(@PathVariable("customerId") String customerId){
        return bookingService.generateCustomerRatingById(customerId);
    }
}
