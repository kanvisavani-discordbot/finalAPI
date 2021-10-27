package com.example.finalApi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.finalApi.model.Level;

@Repository
public interface LevelRepository extends MongoRepository<Level, Integer>{

}