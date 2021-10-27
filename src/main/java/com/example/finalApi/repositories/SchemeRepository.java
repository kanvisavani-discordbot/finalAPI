package com.example.finalApi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.finalApi.model.Scheme;

@Repository
public interface SchemeRepository extends MongoRepository<Scheme, Integer>{

}