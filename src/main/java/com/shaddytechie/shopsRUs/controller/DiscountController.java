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
import com.shaddytechie.shopsRUs.model.Discount;
import com.shaddytechie.shopsRUs.model.Response;
import com.shaddytechie.shopsRUs.service.DiscountService;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

	@Autowired
	DiscountService discountService;
	
	@PostMapping("/create-discount")
	public ResponseEntity<Response> createDiscount(@Valid @RequestBody Discount discount){
		try {
			discountService.createDiscount(discount);
			 return new ResponseEntity<Response>(new Response("00","Discount created Successfully"),HttpStatus.OK);
			 }catch(Exception e) {
				 
				 e.printStackTrace();
				 return new ResponseEntity<Response>(new Response("99","Error Creating Discount"),HttpStatus.BAD_REQUEST);
			 }
	}
	@GetMapping("/display-all")
	public List listAllDiscount() {
		return discountService.getAllDiscounts();
	}
	@GetMapping("/get-percentage/{type}")
	public ResponseEntity<Discount> getByType(@PathVariable String type){
		 Discount discount = discountService.getByType(type);
		 if(discountService.isExistByType(type)) {
		return new ResponseEntity<Discount>(discount,HttpStatus.OK);
		 }else {
			 return new ResponseEntity<Discount>(new Discount("Discount Not Found"),HttpStatus.NOT_FOUND);
		 }
	}
}
