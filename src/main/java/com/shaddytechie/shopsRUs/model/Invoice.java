package com.shaddytechie.shopsRUs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Invoice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String customerId;
private double amount;
private String transactionId;
private String purchaseType;
private double totalAmount;
private int percentage;

public Invoice(String purchaseType) {
	
	this.purchaseType = purchaseType;
}

public Invoice(String transactionId, String purchaseType) {
	
	this.transactionId = transactionId;
	this.purchaseType = purchaseType;
}




}
