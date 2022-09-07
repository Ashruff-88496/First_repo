package com.zensar.tp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.tp.Dto.AuthenticationRequest;
import com.zensar.tp.Dto.Dto;
import com.zensar.tp.Dto.auth;
import com.zensar.tp.service.UserService;
import com.zensar.tp.utils.JwtUtils;

//import com.zenser.tp.Dto.auth;
//import com.example.demo.entity.UserEntity;
////import com.example.demo.Dto.Dto;

////import com.example.demo.service.UserService;
//import com.example.demo.utils.JwtUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

//import com.example.demo.dto.Dto;

@RestController
@RequestMapping("/home")
public class UserController {
	private static final String BadCredentialsException = "User don't exist";
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserDetailsService userService;
	@Autowired
	UserService usservice;
	@Autowired
	JwtUtils jwtUtils;
	
	//returns user information
    @GetMapping(value="/user", produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Dto> returnUsersInfo (@RequestHeader("Authorization")String jwtToken){
        String username = jwtUtils.extractUsername(jwtToken);
        Dto user;
        user = usservice.findUserByUsername(username).get(0);
        return new ResponseEntity<Dto>(user,HttpStatus.ACCEPTED);
}

	
	
//	@GetMapping(value="/user/{Id}",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
//	@ApiOperation(value="Returns User by Id",notes="Returns User By Id situated in the db")
//	public Dto getUserById(@ApiParam(value="User Identifier",required=true)@PathVariable("Id") int sId)
//	{
//
//				return usservice.getUserById(sId);
//
//	}
//	
//	@GetMapping(value="/user",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
//	@ApiOperation(value="Returns all Stocks",notes="This service returns all stocks situated in the market")
//	public List<Dto> getAllUsers()
//	{
//		return usservice.getAllUsers();
//		
//	}
	@ApiOperation(value="Admin or User Authentication",notes="This API endpoint is used for Authentication")
	@PostMapping(value="/authenticate",consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<auth> authenticate(@RequestBody AuthenticationRequest authRequest){
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
					);
		}
		catch(BadCredentialsException e) {
			return new ResponseEntity<auth>(HttpStatus.BAD_REQUEST);
		}
		
	String jwtToken=jwtUtils.generateToken(authRequest.getUsername());
	
	
	String username=jwtUtils.extractUsername(jwtToken);
	
	//UserDetails userDetails=userDetailsService.loadUserByUsername(username);
	UserDetails userDetails=userService.loadUserByUsername(username);
	String role=userDetails.getAuthorities().toString();
	auth list=new auth();
	list.setToken(jwtToken);
	list.setRole(role);
		return new ResponseEntity<auth>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/user")
	public String User() {
		return "User";
	}
	@GetMapping("/admin")
	public String Admin() {
		return "Admin";
	}
	

	static List<Dto> stocks=new ArrayList<>();
	static int lastStockId=1;
}
