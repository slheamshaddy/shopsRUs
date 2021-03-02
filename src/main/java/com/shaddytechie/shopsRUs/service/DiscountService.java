package com.shaddytechie.shopsRUs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaddytechie.shopsRUs.model.Discount;
import com.shaddytechie.shopsRUs.repository.DiscountRepository;

@Service
public class DiscountService {
@Autowired
DiscountRepository discountRepository;

	public void createDiscount(Discount discount) {
		discountRepository.save(discount);
	}
	
	public List getAllDiscounts() {
		return discountRepository.findAll();
	}

	public boolean isExistByType(String type) {
		return discountRepository.existsByType(type);
		
	}
	
	public Discount getByType(String type) {
		return discountRepository.getByType(type);
		
	}
}
