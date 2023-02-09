package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static enum Role {
		ROLE_USER, ROLE_ADMIN	// roles should start with capital ROLE_ and has to be completely in capital letters
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column( nullable = false )
	private String fname;
	
	// @Enumerated allows us to use enums to only allow certain values through, 
	// enums will be stored as strings/varchars in our DB
	@Enumerated(EnumType.STRING)
	@Column( nullable = false )
	private Role role;
	
	@Column( nullable = false )
	private String lname;
	
	// unique and not null
	@Column( unique = true, nullable = false )
	@NotBlank
	private String username;
	
	@Column( nullable = false )
	@NotBlank
	private String password;
	
	@Column( columnDefinition = "boolean default true" )
	private boolean enabled; // true or false if the user is enabled
	
	public User() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", role=" + role + ", lname=" + lname + ", username=" + username
				+ ", password=" + password + ", enabled=" + enabled + "]";
	}

	
	
	
}


