package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.WorkoutSession;
import com.cognixia.jump.repository.WorkoutSessionRepository;


@RequestMapping("/api")
@RestController
public class WorkoutSessionController {
	@Autowired
	WorkoutSessionRepository repo;
	
	@GetMapping("/workout")
	public List<WorkoutSession> getWorkoutSessions() {
		return repo.findAll();
	}
	
	@PostMapping("/workout")
	public ResponseEntity<WorkoutSession> addUser(@RequestBody WorkoutSession workoutSession) {
		
		System.out.println(workoutSession);
		
		workoutSession.setSession_id(-1);
		
		WorkoutSession created = repo.save(workoutSession);
		
		return ResponseEntity.status(201).body(created);
	}
	
	
	
	
	
}