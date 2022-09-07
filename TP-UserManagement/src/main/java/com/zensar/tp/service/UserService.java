package com.zensar.tp.service;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zensar.tp.Dto.Dto;


public interface UserService {
//   Dto getUserById(int stockId);
//	List<Dto> getAllUsers();
	List<Dto> findUserByUsername(String username) throws UsernameNotFoundException;

}
