package com.elife.projet_ff.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.elife.projet_ff.model.Report;

@Repository

public interface ReportRepository extends MongoRepository<Report, String> {

}