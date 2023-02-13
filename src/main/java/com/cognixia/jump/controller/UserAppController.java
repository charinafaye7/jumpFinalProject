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
import com.cognixia.jump.model.UserApp;
import com.cognixia.jump.repository.UserAppRepository;

@RequestMapping("/api")
@RestController
public class UserAppController {
	@Autowired
	UserAppRepository repo;
	
	@GetMapping("/users")
	public List<UserApp> getUsers() {
		return repo.findAll();
	}
	
	@PostMapping("/user")
	public ResponseEntity<UserApp> addUser(@RequestBody UserApp user) {
		
		System.out.println(user);
		
		user.setUser_id(-1);
		
		UserApp created = repo.save(user);
		
		return ResponseEntity.status(201).body(created);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) throws ResourceNotFoundException {
		
		Optional<UserApp> found = repo.findById(id);
		
		if(found.isEmpty()) {
			throw new ResourceNotFoundException("User with id " + id + " was not found");
		}
		
		repo.deleteById(id);
		
		return ResponseEntity.status(200).body(found.get());
	}
	
	@PutMapping("/user/update")
	public ResponseEntity<?> updateUser(@RequestBody UserApp user) throws ResourceNotFoundException {
		
		if(repo.existsById(user.getUser_id())) {
			
			UserApp updated = repo.save(user);
			
			return ResponseEntity.status(200).body(updated);
		}
		
		throw new ResourceNotFoundException("Workout session id " + user.getUser_id() + " was not found");
	}
	
}
