package com.shaddytechie.shopsRUs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shaddytechie.shopsRUs.model.CreateResponse;
import com.shaddytechie.shopsRUs.model.Customer;
import com.shaddytechie.shopsRUs.model.Response;
import com.shaddytechie.shopsRUs.service.CustomerService;

//NOTE ----

//BASE URL = http://shopsrus-env.eba-t5bdxpvn.us-east-2.elasticbeanstalk.com/


@RestController
@RequestMapping("/customer")
public class CustomerController {
 @Autowired
 CustomerService customerService;
 @PostMapping("/create-user")
 public ResponseEntity<CreateResponse> createCustomer(@Valid @RequestBody Customer customer){
	 
	 try {
		 if(customer.getType().equals("affiliate")||customer.getType().equals("employee")||
		customer.getType().equals("non")||customer.getType().equals("For every 100 dollar bill")
		||customer.getType().equals("customer over 2 years")) {
	Customer cust = customerService.createCustomer(customer);
	 return new ResponseEntity<CreateResponse>(new CreateResponse("00","User created Successfully",cust),HttpStatus.OK);
		 }else {
			 return new ResponseEntity<CreateResponse>(new CreateResponse("99","Not a Valid Type"),HttpStatus.OK);
				 
		 }
	 }catch(Exception e) {
		 
		 e.printStackTrace();
		 return new ResponseEntity<CreateResponse>(new CreateResponse("99","Error Creating User"),HttpStatus.BAD_REQUEST);
	 }
 }
 @GetMapping("/find-name/{name}")
 public ResponseEntity<Customer>getUserByName(@PathVariable String name) {
	 Customer customer = customerService.findByName(name);
	 if(customerService.isNameExist(name)) {
	return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	 }else {
		 return new ResponseEntity<Customer>(new Customer("Customer Not Found"),HttpStatus.NOT_FOUND);
	 }
 }
 @GetMapping("/find-customerId/{customerId}")
 public ResponseEntity<Customer> getUserById(@PathVariable String customerId) {
	 
	 Customer customer = customerService.findByCustomerId(customerId);;
	 if(customerService.isCustomerIdExist(customerId)) {
	return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	 }else {
		 return new ResponseEntity<Customer>(new Customer("Customer Not Found"),HttpStatus.NOT_FOUND);
	 }
 }
 
 @GetMapping("/allCustomers")
 public List returnAll() {
	 
	return customerService.getAllCustomers(); 
 }
 
}
