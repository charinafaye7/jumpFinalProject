package com.cognixia.jump.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer status_id;
	
	
	// need foreign key / entity relationship tag here	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false)
	private UserApp user;
	
	@Override
	public String toString() {
		return "UserStatus [status_id=" + status_id + ", user=" + user + ", height=" + height + ", weight=" + weight
				+ ", calories_burned=" + calories_burned + ", date_tracked=" + date_tracked + "]";
	}

	public Integer getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}

	public UserApp getUser() {
		return user;
	}

	public void setUser(UserApp user) {
		this.user = user;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getCalories_burned() {
		return calories_burned;
	}

	public void setCalories_burned(Integer calories_burned) {
		this.calories_burned = calories_burned;
	}

	public Date getDate_tracked() {
		return date_tracked;
	}

	public void setDate_tracked(Date date_tracked) {
		this.date_tracked = date_tracked;
	}

	@Column (nullable = false)
	private Integer height;
	
	@Column (nullable = false)
	private Integer weight;
	
	@Column (nullable = false)
	private Integer calories_burned;
	
	@Column (nullable = false)
	private Date date_tracked;
	
	

}
