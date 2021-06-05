package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.BloodCount;

public interface CountRepo extends JpaRepository<BloodCount, Integer> {

	@Query(value = "from BloodCount where id = 1")
	BloodCount bloodCountInParticularGroup();

	@Transactional
	@Modifying
	@Query(value = "update BloodCount set apos = ?1 where id = 1")
	void UpdateBloodCountapos(int valueOfMapper);
	
	@Transactional
	@Modifying
	@Query(value = "update BloodCount set bpos = ?1 where id = 1")
	void UpdateBloodCountbpos(int valueOfMapper);
	
	@Transactional
	@Modifying
	@Query(value = "update BloodCount set abpos = ?1 where id = 1")
	void UpdateBloodCountabpos(int valueOfMapper);
	
	@Transactional
	@Modifying
	@Query(value = "update BloodCount set opos = ?1 where id = 1")
	void UpdateBloodCountopos(int valueOfMapper);
	
	@Transactional
	@Modifying
	@Query(value = "update BloodCount set aneg = ?1 where id = 1")
	void UpdateBloodCountaneg(int valueOfMapper);
	
	@Transactional
	@Modifying
	@Query(value = "update BloodCount set bneg = ?1 where id = 1")
	void UpdateBloodCountbneg(int valueOfMapper);
	
	@Transactional
	@Modifying
	@Query(value = "update BloodCount set abneg = ?1 where id = 1")
	void UpdateBloodCountabneg(int valueOfMapper);
	
	@Transactional
	@Modifying
	@Query(value = "update BloodCount set oneg = ?1 where id = 1")
	void UpdateBloodCountoneg(int valueOfMapper);
	
}
