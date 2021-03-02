package com.shaddytechie.shopsRUs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateResponse {

	private String code;
	 private String message; 
	 private Customer customer;
	 
	public CreateResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}


	 
}
