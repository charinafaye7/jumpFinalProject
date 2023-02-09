package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exercise implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer exercise_id;
	
	@Column( nullable = false )
	private int calorie_burn_rate;
	
	@Column( nullable = false )
	private String exercise_name;
	
	
	
	public Integer getExercise_id() {
		return exercise_id;
	}

	public void setExercise_id(Integer exercise_id) {
		this.exercise_id = exercise_id;
	}

	public String getExercise_name() {
		return exercise_name;
	}

	public void setExercise_name(String exercise_name) {
		this.exercise_name = exercise_name;
	}

	public int getCalorie_burn_rate() {
		return calorie_burn_rate;
	}

	public void setCalorie_burn_rate(int calorie_burn_rate) {
		this.calorie_burn_rate = calorie_burn_rate;
	}

	public Exercise() {

	}

	@Override
	public String toString() {
		return "Exercise [exercise_id=" + exercise_id + ", exercise_name=" + exercise_name + ", calorieBurnRate=" + calorie_burn_rate + "]";
	}
	
	

		
	
}


