package com.example.finalApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalApi.model.User;
import com.example.finalApi.repositories.UserRepository;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping(value="/allUsers")
	public List<User> getAllUsers(){		
		return userRepository.findAll();		
	}
	
	 @GetMapping(value="/users/{id}")
	 public Optional<User> findUsers(@PathVariable Integer id) {	    
	    return userRepository.findById(id);
	  }
	
	@PostMapping(value="/createUser")
	public String createUser(@RequestBody User user) {
		user.setId(service.getSequenceNumber(User.SEQUENCE_NAME));
		User insertedUser=userRepository.save(user);
		return "User created "+insertedUser.getName();
	}
	
	@DeleteMapping(value="/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	  }
	
	@PutMapping(value="/user/{id}")
	public User updateUser(@RequestBody User newUser, @PathVariable Integer id) {
		newUser.setId(id);
	    return userRepository.save(newUser);
	  }	
	
	@PutMapping(value="/password/{id}&{password}")
	public User updatePassword(@RequestBody User newUser, @PathVariable Integer id) {
		newUser.setId(id);
	    return userRepository.save(newUser);
	  }	
}
