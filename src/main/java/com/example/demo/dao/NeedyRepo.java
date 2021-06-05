package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.RequestBlood;

public interface NeedyRepo extends JpaRepository<RequestBlood, Integer>  {
	
	@Transactional
	@Modifying
	@Query(value = "update RequestBlood set status = 'accepted' where blood_donor_id = ?1")
	void acceptRequestWithid(int requestid);

	@Transactional
	@Modifying
	@Query(value = "update RequestBlood set status = 'rejected' where blood_donor_id = ?1")
	void rejectRequestWithid(int requestid);

	@Query("from RequestBlood where userid = ?1")
	List<RequestBlood> findByUserId(int u_id);

	@Query("from RequestBlood where status='pending'")
	List<RequestBlood> findAllbyStatus();
	

}
