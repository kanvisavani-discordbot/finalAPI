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

import com.example.finalApi.model.Scheme;
import com.example.finalApi.repositories.SchemeRepository;

@RestController
@CrossOrigin
public class SchemeController {
	
	@Autowired
	public SchemeRepository schemeRepository;
	
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping(value="/allSchemes")
	public List<Scheme> getAllSchemes(){		
		return schemeRepository.findAll();		
	}
	
	 @GetMapping(value="/schemes/{id}")
	 public Optional<Scheme> findSchemes(@PathVariable Integer id) {	    
	    return schemeRepository.findById(id);
	  }
	
	@PostMapping(value="/b")
	public String createScheme(@RequestBody Scheme scheme) {
		scheme.setId(service.getSequenceNumber(Scheme.SEQUENCE_NAME));
		Scheme insertedScheme=schemeRepository.save(scheme);
		return "Scheme created "+insertedScheme.getName();
	}
	
	@DeleteMapping(value="/schemes/{id}")
	public void deleteScheme(@PathVariable Integer id) {
		schemeRepository.deleteById(id);
	  }
	
	@PutMapping(value="/scheme/{id}")
	public Scheme updateScheme(@RequestBody Scheme newScheme, @PathVariable Integer id) {
		newScheme.setId(id);
	    return schemeRepository.save(newScheme);
	  }	
}
