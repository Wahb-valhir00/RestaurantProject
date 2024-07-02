package com.elife.projet_ff.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elife.projet_ff.model.Reservation;

public interface ReservationRepository extends MongoRepository<Reservation,String>{
    
}
