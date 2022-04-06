package com.rmg.ratingservice.controller;

import com.rmg.ratingservice.entity.Rating;
import com.rmg.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public Rating addRating(@RequestBody Rating rating){
        return ratingService.addRating(rating);
    }

    @GetMapping("/{customerId}")
    public List<Rating> getRatingByCustomerId(@PathVariable ("customerId") String customerId){
        return ratingService.getRatingByCustomerId(customerId);
    }
}
