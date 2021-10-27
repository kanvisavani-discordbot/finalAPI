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

import com.example.finalApi.model.Level;
import com.example.finalApi.repositories.LevelRepository;

@RestController
@CrossOrigin
public class LevelController {
	
	@Autowired
	public LevelRepository levelRepository;
	
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping(value="/allLevels")
	public List<Level> getAllLevels(){		
		return levelRepository.findAll();		
	}
	
	 @GetMapping(value="/levels/{id}")
	 public Optional<Level> findPlan(@PathVariable Integer id) {	    
	    return levelRepository.findById(id);
	  }
	
	@PostMapping(value="/createLevel")
	public String createPlan(@RequestBody Level level) {
		level.setId(service.getSequenceNumber(Level.SEQUENCE_NAME));
		Level insertedLevel=levelRepository.save(level);
		return "Level created "+insertedLevel.getName();
	}
	
	@DeleteMapping(value="/levels/{id}")
	public void deleteLevel(@PathVariable Integer id) {
	    levelRepository.deleteById(id);
	  }
	
	@PutMapping(value="/level/{id}")
	public Level updateLevel(@RequestBody Level newLevel, @PathVariable Integer id) {
		newLevel.setId(id);
	    return levelRepository.save(newLevel);
	  }	
}
