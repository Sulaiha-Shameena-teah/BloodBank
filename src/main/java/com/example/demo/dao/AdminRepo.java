package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Admin;


public interface AdminRepo  extends JpaRepository<Admin, Integer> {

	@Query("from Admin where adminname = ?1 and adminpassword = ?2")
	List<Admin> findAccount(String name, String password);
}
