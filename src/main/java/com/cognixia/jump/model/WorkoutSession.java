package com.cognixia.jump.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkoutSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer session_id;
	
	
	// need foreign key / entity relationship tag here	
	@Column (nullable = false)
	private Integer user_id;
	
	@Column (nullable = false)
	private Date session_date;
	
	@Column (nullable = false)
	private Time duration;
	
	@Column (nullable = false)
	private Integer calories;
	
	// need foreign key / entity relationship tag here	
	@Column (nullable = false)
	private Integer exercise_id;
	
	
	
	

}
