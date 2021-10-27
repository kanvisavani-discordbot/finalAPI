package com.example.finalApi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.finalApi.model.Plan;

@Repository
public interface PlanRepository extends MongoRepository<Plan, Integer>{

}