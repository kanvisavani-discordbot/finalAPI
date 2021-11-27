package com.example.finalApi.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.finalApi.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer>{
	
	@Query("{$and :[{email : ?0},{password : ?1}]}")
	public User getCredentials(@Param("email") String email,@Param("password") String password);
	
}