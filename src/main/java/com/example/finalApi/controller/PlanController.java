package com.example.finalApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping(value="/all")
	public List<Plan> getAllPlans(){		
		return planRepository.findAll();		
	}
	
	@PostMapping(value="/create")
	public String createPlan(@RequestBody Plan plan) {
		plan.setId(service.getSequenceNumber(Plan.SEQUENCE_NAME));
		Plan insertedPlan=planRepository.save(plan);
		return "Plan created "+insertedPlan.getName();
	}
	
}
