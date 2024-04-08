package com.sathys.rest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.autoconfigure.security.oauth2.resource.IssuerUriCondition;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sathys.rest.entity.Hospital;
import com.sathys.rest.model.HospitalDetails;
import com.sathys.rest.repositary.Hospitalrepositary;
@Service
public class Hospitalservice {
	
	@Autowired
	Hospitalrepositary hospitalrepositary;

	public Hospital createHospital(HospitalDetails hospitalDetails) {
		//read the data from model class and set the data to entity
		 Hospital hospital=new Hospital();
		 hospital.setName(hospitalDetails.getName());
		 hospital.setLocation(hospitalDetails.getLocation());
		 hospital.setRating(hospitalDetails.getRating());
		 hospital.setEmail(hospitalDetails.getEmail());
		 hospital.setMobile(hospitalDetails.getMobile());
		 hospital.setCreatedAt(LocalDateTime.now());
		 hospital.setCreatedBy(System.getProperty("user.name"));
		 
		Hospital savedhospital=hospitalrepositary.save(hospital);
		return savedhospital;
	}

	public Optional<Hospital> getid(@PathVariable Long id) {
		Optional<Hospital> details=hospitalrepositary.findById(id);
		return details;
		 
	}
	public List<Hospital> saveAllHospitals(List<HospitalDetails> hospitalDetails) {
		List<Hospital> hospitals=new ArrayList<>();
		for(HospitalDetails hospitalDetails2:hospitalDetails) {
		 Hospital hospital=new Hospital();
		 hospital.setName(hospitalDetails2.getName());
		 hospital.setLocation(hospitalDetails2.getLocation());
		 hospital.setRating(hospitalDetails2.getRating());
		 hospital.setEmail(hospitalDetails2.getEmail());
		 hospital.setMobile(hospitalDetails2.getMobile());
		 hospital.setCreatedAt(LocalDateTime.now());
		 hospital.setCreatedBy(System.getProperty("user.name"));
		 hospitals.add(hospital);
		}  
	
	return hospitalrepositary.saveAll(hospitals);
	}
	public List<Hospital> findall(){
		return hospitalrepositary.findAll();
	}
	public void deletebyid(@PathVariable Long id) {
		 
					hospitalrepositary.deleteById(id);
					 	
		 
	}
	public Hospital updateHospital(long id,  HospitalDetails hospitalDetails) {
        Optional<Hospital> optionalHospital = hospitalrepositary.findById(id);
        Hospital hospital=null;
        if (optionalHospital.isPresent()) {
         hospital = optionalHospital.get();
         hospital.setName(hospitalDetails.getName());
   		 hospital.setLocation(hospitalDetails.getLocation());
   		 hospital.setRating(hospitalDetails.getRating());
   		 hospital.setEmail(hospitalDetails.getEmail());
		 hospital.setMobile(hospitalDetails.getMobile());
   		 hospital.setCreatedAt(LocalDateTime.now());
   		 hospital.setCreatedBy(System.getProperty("user.name"));
   		 
   		 
            return hospitalrepositary.save(hospital);
        } else 
        {
            return hospitalrepositary.save(hospital);
        }
    }
	public org.springframework.data.domain.Page<Hospital> getAllDataPaging(int pageNumber,int pageSize){
		org.springframework.data.domain.Pageable pageable=PageRequest.of(pageNumber, pageSize);
		return  hospitalrepositary.findAll(pageable);
	}
 
}
