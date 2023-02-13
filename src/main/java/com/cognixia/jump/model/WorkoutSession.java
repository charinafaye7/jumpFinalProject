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
	
	public WorkoutSession() {
		
	}
	
	public WorkoutSession(Integer session_id, UserApp user, Date session_date, Time duration, Integer calories,
			Exercise exercise) {
		super();
		this.session_id = session_id;
		this.user = user;
		this.session_date = session_date;
		this.duration = duration;
		this.calories = calories;
		this.exercise = exercise;
	}

	@Override
	public String toString() {
		return "WorkoutSession [session_id=" + session_id + ", user=" + user + ", session_date=" + session_date
				+ ", duration=" + duration + ", calories=" + calories + ", exercise=" + exercise + "]";
	}
	
	public String toJson() {

		return "{\"id\" : " + session_id 
				+ ", \"user\" : \"" + user + "\""
				+ ", \"session_date\" : \"" + session_date + "\""
				+ ", \"duration\" : \"" + duration + "\""
				+ ", \"calories\" : " + calories 
				+ ", \"exercise\" : \"" + exercise + "\"";
	}

	public Integer getSession_id() {
		return session_id;
	}

	public void setSession_id(Integer session_id) {
		this.session_id = session_id;
	}

	public UserApp getUser() {
		return user;
	}

	public void setUser(UserApp user) {
		this.user = user;
	}

	public Date getSession_date() {
		return session_date;
	}

	public void setSession_date(Date session_date) {
		this.session_date = session_date;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	
	
}
