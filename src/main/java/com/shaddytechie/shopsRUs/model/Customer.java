package com.shaddytechie.shopsRUs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
    @NotBlank(message = "Name is mandatory")
	private String name;
	private String customerId;
	@NotBlank(message = "Email is mandatory")
	private String email;
	@NotBlank(message = "type is mandatory")
	private String type;
	private String dateCreated;
	
	public Customer(@NotBlank(message = "Name is mandatory") String name) {
		
		this.name = name;
	}
	
	
	
}
