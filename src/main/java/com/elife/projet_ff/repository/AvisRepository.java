package com.elife.projet_ff.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elife.projet_ff.model.Avis;

public interface AvisRepository extends MongoRepository<Avis,String>{
    
}
