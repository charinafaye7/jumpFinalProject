package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.UserApp;
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
	
	
	
	
	
}







