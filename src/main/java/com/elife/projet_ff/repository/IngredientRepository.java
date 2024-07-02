package com.elife.projet_ff.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.elife.projet_ff.model.Ingredient;
@Repository

public interface IngredientRepository extends MongoRepository<Ingredient,String> {
    
}
