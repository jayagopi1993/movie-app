package com.rmg.ratingservice.repo;

import com.rmg.ratingservice.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepo extends MongoRepository<Rating,String> {

    List<Rating> findByCustomerId(String customerId);
}
