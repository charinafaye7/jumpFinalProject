package com.cognixia.jump.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.UserStatus;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, Integer>{
	
	// insert queries here

}

