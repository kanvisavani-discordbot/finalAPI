package com.example.finalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.finalApi.model.AuthenticationRequest;
import com.example.finalApi.model.AuthenticationResponse;

public class AuthController {
	
	@PostMapping(value="/auth")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest){
		
		String username=authenticationRequest.getFullName();
		String password=authenticationRequest.getPassword();
		
		
		return ResponseEntity.ok(new AuthenticationResponse("Succesful Authentication for client "+username));
	}

}
