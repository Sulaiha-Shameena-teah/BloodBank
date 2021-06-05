package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.UserRegister;

public interface UserRepo extends JpaRepository<UserRegister, Integer> 
{
	@Query("from UserRegister where user_name = ?1 and password = ?2")
	List<UserRegister> findAccount(String name, String password);
}
