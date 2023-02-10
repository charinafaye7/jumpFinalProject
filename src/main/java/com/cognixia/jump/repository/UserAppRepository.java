package com.cognixia.jump.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.UserApp;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Integer>{

	Optional<UserApp> findByUsername(String username);
	
	// insert queries here

}