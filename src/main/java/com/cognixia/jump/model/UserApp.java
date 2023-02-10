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
public class UserApp implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static enum Role {
		ROLE_USER, ROLE_ADMIN	// roles should start with capital ROLE_ and has to be completely in capital letters
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	
	@Column( nullable = false )
	private String f_name;
	
	@Column( nullable = false )
	private String l_name;
	
	// @Enumerated allows us to use enums to only allow certain values through, 
	// enums will be stored as strings/varchars in our DB
	@Enumerated(EnumType.STRING)
	@Column( nullable = false )
	private Role roles;
	
	
	
	// unique and not null
	@Column( unique = true, nullable = false )
	@NotBlank
	private String username;
	
	@Column( nullable = false )
	@NotBlank
	private String user_pwd;
	
	@Column( columnDefinition = "boolean default true" )
	private boolean enabled; // true or false if the user is enabled
	
	public UserApp() {

	}
	

	public Integer getUser_id() {
		return user_id;
	}



	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}



	public String getF_name() {
		return f_name;
	}



	public void setF_name(String f_name) {
		this.f_name = f_name;
	}



	public String getL_name() {
		return l_name;
	}



	public void setL_name(String l_name) {
		this.l_name = l_name;
	}



	public Role getRoles() {
		return roles;
	}



	public void setRoles(Role roles) {
		this.roles = roles;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getUser_pwd() {
		return user_pwd;
	}



	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}



	@Override
	public String toString() {
		return "User [id=" + user_id + ", f_name=" + f_name + ", roles=" + roles + ", l_name=" + l_name + ", username=" + username
				+ ", password=" + user_pwd + ", enabled=" + enabled + "]";
	}

}



