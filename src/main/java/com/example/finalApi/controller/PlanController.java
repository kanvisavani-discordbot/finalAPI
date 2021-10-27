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

import com.example.finalApi.model.Plan;
import com.example.finalApi.repositories.PlanRepository;

@RestController
@CrossOrigin
public class PlanController {
	
	@Autowired
	public PlanRepository planRepository;
	
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping(value="/allPlans")
	public List<Plan> getAllPlans(){		
		return planRepository.findAll();		
	}
	
	 @GetMapping(value="/plans/{id}")
	 public Optional<Plan> findPlan(@PathVariable Integer id) {	    
	    return planRepository.findById(id);
	  }
	
	@PostMapping(value="/createPlan")
	public String createPlan(@RequestBody Plan plan) {
		plan.setId(service.getSequenceNumber(Plan.SEQUENCE_NAME));
		Plan insertedPlan=planRepository.save(plan);
		return "Plan created "+insertedPlan.getName();
	}
	
	@DeleteMapping(value="/plans/{id}")
	public void deletePlan(@PathVariable Integer id) {
	    planRepository.deleteById(id);
	  }
	
	@PutMapping(value="/plan/{id}")
	public Plan updatePlan(@RequestBody Plan newPlan, @PathVariable Integer id) {
		newPlan.setId(id);
	    return planRepository.save(newPlan);
	  }	
}
