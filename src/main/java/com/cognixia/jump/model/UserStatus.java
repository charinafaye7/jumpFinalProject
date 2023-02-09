package com.cognixia.jump.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer status_id;
	
	
	// need foreign key / entity relationship tag here	
	@Column (nullable = false)
	private Integer user_id;
	
	@Column (nullable = false)
	private Integer height;
	
	@Column (nullable = false)
	private Integer weight;
	
	@Column (nullable = false)
	private Integer calories_burned;
	
	@Column (nullable = false)
	private Date date_tracked;
	
	

}
