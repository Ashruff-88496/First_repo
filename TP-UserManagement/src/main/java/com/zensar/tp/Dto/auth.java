package com.zensar.tp.Dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="Auth-token and role value")
public class auth {
	@ApiModelProperty(value="Token")
	private String Token;
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	@ApiModelProperty(value="Role")
	private String Role;
	

}
