package com.zensar.df.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zensar.df.dto.UserDto;
import com.zensar.df.entity.BlackListEntity;
import com.zensar.df.entity.UserEntity;
import com.zensar.df.repo.BlacklistRepo;
import com.zensar.df.repo.UserRepo;
import com.zensar.df.utils.JwtUtils;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{

	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	JwtUtils jwtUtils;
	

	@Override
	public UserDto registerUser(UserDto userdto) {
		UserEntity userEntity=new UserEntity(userdto.getFirstname(), userdto.getLastname(), userdto.getUsername(), userdto.getPassword(), userdto.getEmail(), userdto.getPhone(), userdto.getRole());
		userEntity=userRepo.save(userEntity);
		userdto=new UserDto(userEntity.getId(), userEntity.getFirst_name(), userEntity.getLast_name(), userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail(), userEntity.getPhone(), userEntity.getRoles());
		return userdto;
	}
	static List<UserDto> users = new ArrayList<>();
	static int lastUserId = 0;
	
	@Autowired
	BlacklistRepo Blrepo;
	
	@Override
    public Boolean logoutUser(String auth) {
    	BlackListEntity be=new BlackListEntity(auth, LocalDateTime.now());
    	be=Blrepo.save(be);
    	return true;
    }
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// Write user Entity and UserRepo
		List<UserEntity>userEntityList =userRepo.findByUsername(username);
		if(userEntityList==null || userEntityList.size()==0) {
			throw new UsernameNotFoundException(username);
		}
		UserEntity userEntity = userEntityList.get(0);
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(userEntity.getRoles()));
		User user = new User(userEntity.getUsername(), userEntity.getPassword(),authorities);
		return user;
		
	}

}
