package com.sathys.rest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sathys.rest.entity.Hospital;
import com.sathys.rest.model.HospitalDetails;
import com.sathys.rest.repositary.Hospitalrepositary;
import com.sathys.rest.service.Hospitalservice;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



 


@RestController
@RequestMapping("api/sathya")
public class Testcontroller {
	
	@Autowired
	 Hospitalservice hospitalservice;
		@PostMapping("/save")
		public Hospital createHospital(@Valid @RequestBody HospitalDetails hospitalDetails) {
			 
			
			return hospitalservice.createHospital(hospitalDetails);
		}
		@GetMapping("/getbyid/{id}")
		 public Optional<Hospital> getid(@PathVariable Long id){
			return hospitalservice.getid(id);
		}
		@PostMapping("/saveall")
		public List<Hospital>  saveAllHospitals(@RequestBody List<HospitalDetails> hospitalDetails){
			return hospitalservice.saveAllHospitals(hospitalDetails);
			
		}
		@GetMapping("/findall")
		public List<Hospital> findall(@RequestBody List<HospitalDetails> hospitalDetails){
			return hospitalservice.findall();
		}
		@DeleteMapping("/deletebyid/{id}")
		public void  deletebyid(@PathVariable Long id) {
			 hospitalservice.deletebyid(id);
		}
		@PutMapping("/update/{id}")
		public Hospital updateHospital(@PathVariable long id,@RequestBody HospitalDetails hospitalDetails) {
			return hospitalservice.updateHospital(id, hospitalDetails);
		}
		@GetMapping("/{pageNumber}/{pageSize}")
		public org.springframework.data.domain.Page<Hospital> getAllHospitalPaging(@PathVariable int pageNumber,@PathVariable int pageSize){
			return hospitalservice.getAllDataPaging(pageNumber, pageSize);
		}
}
