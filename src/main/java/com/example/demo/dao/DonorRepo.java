package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.SaveBlood;


public interface DonorRepo extends JpaRepository<SaveBlood, Integer> {
	
	
	@Query("from SaveBlood where bloodgroup = ?1")
	List <SaveBlood> findAllDonor(String bloodgroup);
	
	@Transactional
	@Modifying
	@Query(value = "update SaveBlood set status = 'accepted' where blood_donor_id = ?1")
	void acceptRequestWithid(int requestid);

	@Transactional
	@Modifying
	@Query(value = "update SaveBlood set status = 'rejected' where blood_donor_id = ?1")
	void rejectRequestWithid(int requestid);

	@Query("from SaveBlood where userid = ?1")
	List<SaveBlood> findByUserId(int u_id);

	@Query("from SaveBlood where status='pending'")
	List<SaveBlood> findAllbyStatus();
	

}
