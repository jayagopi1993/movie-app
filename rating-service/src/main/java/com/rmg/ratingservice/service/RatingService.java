package com.rmg.ratingservice.service;

import com.rmg.ratingservice.entity.Rating;
import com.rmg.ratingservice.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    public Rating addRating(Rating rating){
        return ratingRepo.save(rating);
    }

    public List<Rating> getRatingByCustomerId(String customerId){
        System.out.println("customerId :"+customerId);
        return ratingRepo.findByCustomerId(customerId);
    }
}
