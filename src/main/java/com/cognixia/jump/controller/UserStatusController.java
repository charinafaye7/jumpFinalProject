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
import com.cognixia.jump.model.UserStatus;
import com.cognixia.jump.repository.UserStatusRepository;

@RequestMapping("/api")
@RestController
public class UserStatusController {
	@Autowired
	UserStatusRepository repo;
	
	@GetMapping("/status")
	public List<UserStatus> getStatus() {
		return repo.findAll();
	}
	
	@PostMapping("/status")
	public ResponseEntity<UserStatus> addStatus(@RequestBody UserStatus status) {
		
		System.out.println(status);
		
		status.setStatus_id(-1);
		
		UserStatus created = repo.save(status);
		
		return ResponseEntity.status(201).body(created);
	}
	
	@DeleteMapping("/status/{id}")
	public ResponseEntity<?> deleteStatus(@PathVariable int id) throws ResourceNotFoundException {
		
		Optional<UserStatus> found = repo.findById(id);
		
		if(found.isEmpty()) {
			throw new ResourceNotFoundException("User status with " + id + " was not found");
		}
		
		repo.deleteById(id);
		
		return ResponseEntity.status(200).body(found.get());
	}
	
	@PutMapping("/status/update")
	public ResponseEntity<?> updateStatus(@RequestBody UserStatus status) throws ResourceNotFoundException {
		
		if(repo.existsById(status.getStatus_id())) {
			
			UserStatus updated = repo.save(status);
			
			return ResponseEntity.status(200).body(updated);
		}
		
		throw new ResourceNotFoundException("Workout session id " + status.getStatus_id() + " was not found");
	}
	
}
