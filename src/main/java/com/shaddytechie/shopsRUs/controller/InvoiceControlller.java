package com.shaddytechie.shopsRUs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shaddytechie.shopsRUs.model.Invoice;
import com.shaddytechie.shopsRUs.model.Response;
import com.shaddytechie.shopsRUs.model.TransactionRequest;
import com.shaddytechie.shopsRUs.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceControlller {

	@Autowired
	InvoiceService invoiceService;
	@PostMapping("/generate-invoice")
	public ResponseEntity<Invoice> generateInvoice(@Valid @RequestBody TransactionRequest transact){
		
		try {
			if(transact.getPurchaseType().equals("grocery")||transact.getPurchaseType().equals("non-grocery")) {
			return new ResponseEntity<Invoice>(invoiceService.makeInvoice(transact),HttpStatus.OK);
//			return new ResponseEntity<Invoice>(new Response("00","Successful"),HttpStatus.OK);
			}else {
				return new ResponseEntity<Invoice>(new Invoice("Choose either grocery or non-grocery"),HttpStatus.BAD_REQUEST);	
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Invoice>(new Invoice("null","Error Generating Invoice"),HttpStatus.BAD_REQUEST);	
			}
	}
}
