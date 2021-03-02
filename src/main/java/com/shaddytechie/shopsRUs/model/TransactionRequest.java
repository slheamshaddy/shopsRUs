package com.shaddytechie.shopsRUs.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    @NotNull
	private String customerId;
	@NotNull
	private double amount;
	@NotNull
	private String purchaseType;
	
}
