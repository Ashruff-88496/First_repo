package com.zensar.tp.Dto;

public class Dto {
	public Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;
	@Override
	public String toString() {
		return "Dto [id=" + id + ", email=" + email + ", password=" + password + ", username=" + username + "]";
	}
	private String email;
	private String password;
	private String username;

	public Dto(int id,String email,String username, String password) {
		super();
		this.id=id;
		this.email = email;
		this.username=username;
		this.password = password;
	}
	/*
	 * public Dto(int id, String email, String password, String username, String
	 * jwtToken) { super(); this.id = id; this.email = email; this.password =
	 * password; this.username = username; JwtToken = jwtToken; }
	 */

	/*
	 * @Override public String toString() { return "Dto [id=" + id + ", email=" +
	 * email + ", password=" + password + ", username=" + username + ", JwtToken=" +
	 * JwtToken + "]"; }
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	/*
	 * public String getJwtToken() { return JwtToken; }
	 */
	/*
	 * private String JwtToken; public void setJwtToken(String JwtToken) {
	 * this.JwtToken=JwtToken; } public String getJwtToken(String JwtToken) { return
	 * JwtToken; }
	 */
}
