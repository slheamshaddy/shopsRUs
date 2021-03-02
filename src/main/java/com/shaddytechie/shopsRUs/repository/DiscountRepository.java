package com.shaddytechie.shopsRUs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shaddytechie.shopsRUs.model.Discount;
@Repository
public interface DiscountRepository extends JpaRepository<Discount,Integer>{

	@Query(
	  value = "SELECT * FROM discount WHERE type = :type", 
	  nativeQuery = true)
Discount getByType(@Param("type")String type);
	
	boolean existsByType(String type);
	Discount findByPercentage(String type);
}
