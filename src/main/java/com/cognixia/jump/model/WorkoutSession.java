package com.cognixia.jump.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WorkoutSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer session_id;
	
	@ManyToOne
	@JoinColumn (name = "user_id", nullable = false)
	private UserApp user;
	
	@Column (nullable = false)
	private Date session_date;
	
	@Column (nullable = false)
	private Time duration;
	
	@Column (nullable = false)
	private Integer calories;
	
	@ManyToOne
	@JoinColumn (name = "exercise_id", nullable = false)
	private Exercise exercise;
	
}
