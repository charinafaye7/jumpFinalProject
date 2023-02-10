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
	
	
	
	
	
}





