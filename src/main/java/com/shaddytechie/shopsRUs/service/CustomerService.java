package com.shaddytechie.shopsRUs.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaddytechie.shopsRUs.model.Customer;
import com.shaddytechie.shopsRUs.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
	CustomerRepository customerRepository;
    
    public Customer createCustomer(Customer customer) {
    	customer.setDateCreated(getDate());
    	customer.setCustomerId(UUID.randomUUID().toString());
    	customerRepository.save(customer);
    	return customerRepository.findByCustomerId(customer.getCustomerId());
    }
    
    public Customer findByCustomerId(String customerId) {
    	return customerRepository.findByCustomerId(customerId);
    }
    
    public Customer findByName(String name) {
    	return customerRepository.findByName(name);
    }
    
    public Boolean isNameExist(String name) {
    return customerRepository.existsByName(name);
    }
    public Boolean isCustomerIdExist(String customerId) {
    return customerRepository.existsByCustomerId(customerId);
    }
    
    public String getDate() {
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        return formatter.format(date);
    }
    
    public List getAllCustomers() {
    	return customerRepository.findAll();
    }
}
