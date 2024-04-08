package com.sathys.rest.repositary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sathys.rest.entity.Hospital;

import jakarta.transaction.Transactional;

@Repository
public interface Hospitalrepositary extends JpaRepository<Hospital, Long>{

	 
	 
			
}
