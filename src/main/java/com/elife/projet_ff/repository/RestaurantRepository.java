package com.elife.projet_ff.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.elife.projet_ff.model.Restaurant;
@Repository

public interface RestaurantRepository extends MongoRepository<Restaurant,String> {
    
}
