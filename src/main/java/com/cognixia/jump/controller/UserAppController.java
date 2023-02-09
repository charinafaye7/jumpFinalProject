package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}