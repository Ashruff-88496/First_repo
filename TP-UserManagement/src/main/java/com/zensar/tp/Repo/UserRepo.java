package com.zensar.tp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.tp.userEntity.UserEntity;


public interface UserRepo extends JpaRepository<UserEntity,Integer> {
//	List<UserEntity> findByUsername(String username);
//	
	List<UserEntity> findByUsername(String username);



}
