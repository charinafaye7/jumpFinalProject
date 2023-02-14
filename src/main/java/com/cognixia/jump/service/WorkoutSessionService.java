package com.cognixia.jump.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.WorkoutSession;
import com.cognixia.jump.repository.WorkoutSessionRepository;

@Service
public class WorkoutSessionService {
	
	@Autowired
	WorkoutSessionRepository repo;
	
	public boolean deleteSession(int id) throws ResourceNotFoundException {
		boolean exists = repo.existsById(id);
		
		if(exists) {
			repo.deleteById(id);
			return true;
		}
	
		throw new ResourceNotFoundException("id");
//		return false;
	}
	
	public WorkoutSession updateSession(WorkoutSession session) throws ResourceNotFoundException {
		
		boolean exists = repo.existsById(session.getSession_id());
		
		if(exists) {
		
			WorkoutSession updated = repo.save(session);
			
			return updated;
			
		}
		
		throw new ResourceNotFoundException( "Workout Session " + session.getSession_id() );
	}

}
