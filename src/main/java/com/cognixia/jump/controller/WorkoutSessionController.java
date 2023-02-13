package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.WorkoutSession;
import com.cognixia.jump.repository.WorkoutSessionRepository;
import com.cognixia.jump.service.WorkoutSessionService;

@RequestMapping("/api")
@RestController
public class WorkoutSessionController {
	
	@Autowired
	WorkoutSessionService service;
	
	@Autowired
	WorkoutSessionRepository repo;
	
	@GetMapping("/workout")
	public List<WorkoutSession> getWorkoutSessions() {
		return repo.findAll();
	}
	
	@PostMapping("/workout")
	public ResponseEntity<WorkoutSession> addWorkout(@RequestBody WorkoutSession workoutSession) {
		
		System.out.println(workoutSession);
		
		workoutSession.setSession_id(-1);
		
		WorkoutSession created = repo.save(workoutSession);
		
		return ResponseEntity.status(201).body(created);
	}
	
	@DeleteMapping("/workout/{id}")
	public ResponseEntity<?> deleteWorkout(@PathVariable int id) throws ResourceNotFoundException {
		service.deleteSession(id);
		
		return ResponseEntity.status(200)
				 .body("Deleted Session with id = " + id);
	}
	
	@PutMapping("/workout/update")
	public ResponseEntity<?> updateWorkout(@RequestBody WorkoutSession session) throws ResourceNotFoundException {
		
		WorkoutSession updated = service.updateSession(session);
		
		return ResponseEntity.status(200)
				 .body(updated);
		
		
	}
		
}