package com.zensar.tp.userEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Table(name="users")
public class UserEntity {
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="Id")
	private int id;
	@Column(name="f_name")
	private String fname;
	@Column(name="l_name")
	private String lname;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	private String role="ROLE_USER";
	@Column(name="email")
	private String email;
	@Column(name="mobile")
	private int mobile;
	public UserEntity(String email, String username, String password) {
		super();
		this.email = email;
		this.username=username;
		this.password = password;
	}
	public UserEntity(int id, String email, String username, String password) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
			return email;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
