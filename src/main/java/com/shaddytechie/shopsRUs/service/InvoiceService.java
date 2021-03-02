package com.shaddytechie.shopsRUs.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaddytechie.shopsRUs.model.Customer;
import com.shaddytechie.shopsRUs.model.Discount;
import com.shaddytechie.shopsRUs.model.Invoice;
import com.shaddytechie.shopsRUs.model.TransactionRequest;
import com.shaddytechie.shopsRUs.repository.CustomerRepository;
import com.shaddytechie.shopsRUs.repository.DiscountRepository;
import com.shaddytechie.shopsRUs.repository.InvoiceRepository;

@Service
public class InvoiceService {
	@Autowired
	InvoiceRepository invoiceRepository;
	@Autowired
	DiscountRepository discountRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	public Invoice makeInvoice(TransactionRequest transaction) {
		
		String discount = "discount";
		
		Invoice invoice = new Invoice();
		invoice.setAmount(transaction.getAmount());
		invoice.setCustomerId(transaction.getCustomerId());
		invoice.setPurchaseType(transaction.getPurchaseType());
		invoice.setTransactionId(UUID.randomUUID().toString());
		
		
		String type = getType(transaction.getCustomerId());
		int percentage = getPercentage(type);
		
		invoice.setPercentage(percentage);
		
		System.out.println("Percentage is "+ percentage);
		System.out.println("Type is "+ type);
		System.out.println("Amount is "+ transaction.getAmount());
		if(invoice.getPurchaseType().equals("grocery")) {
			discount = "no-discount";
			
		}
		
		invoice.setTotalAmount(calculateTotal(transaction.getAmount(),percentage,discount));
		
		invoiceRepository.save(invoice);
		return invoice;
	}
	
	public double calculateTotal(double amount,int percentage,String discount) {
		double total=0;
		if(discount.equals("discount")) {
		total = amount*percentage/100;
		total = amount - total;
		}else {
	    total =amount;
		}
		
		return total;
		
	}
	
	
	
	public String getType(String customerId) {
		Customer customer = customerRepository.findByCustomerId(customerId);
		String type = customer.getType();
		return type;
		
	}
	
	public int getPercentage(String type) {
		System.out.println("TYPE IS "+ type);
		Discount discount = discountRepository.getByType(type);
		System.out.println("THIS IS DISCOUNT "+discount);
		int percentage = Integer.parseInt(discount.getPercentage());
		return percentage;
	}
	
	

}
