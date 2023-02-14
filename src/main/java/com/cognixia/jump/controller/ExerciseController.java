package com.cognixia.jump.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Exercise;
import com.cognixia.jump.repository.ExerciseRepository;

@RestController
@RequestMapping("/api")
public class ExerciseController {
	@Autowired
	ExerciseRepository repo;
	
	@GetMapping("/exercise/exerciseName")
	public List<Exercise> specificExercise(@PathParam(value = "exercise") String exercise) {
		
		return repo.exerciseName(exercise);
	}
}