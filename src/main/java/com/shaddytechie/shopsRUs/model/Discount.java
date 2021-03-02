package com.shaddytechie.shopsRUs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "Discount")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    @NotNull
    @Pattern(message = "quantity must be a number", regexp="^[0-9]*$")
	private String percentage;
    @NotNull(message = "Name is mandatory")
	private String type;
	
	public Discount(String type) {
		
		this.type = type;
	}
	
	
}
