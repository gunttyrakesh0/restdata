package com.sathys.rest.model;

import com.sathys.rest.entity.Hospital;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalDetails {
	
	@NotBlank(message ="Hospital name required")
	private String name;
	
	@NotBlank(message = "location is required")
	private String location;
	
	private double rating;
	@Email(message = "Invalid email adress")
	@NotBlank(message = "Email is required")
	private String email;
	@Pattern(regexp = "[0-9]{10}", message = "Invalid mobile number")
	@NotBlank(message = "mobile number is required")
	private String mobile;
	 

}
