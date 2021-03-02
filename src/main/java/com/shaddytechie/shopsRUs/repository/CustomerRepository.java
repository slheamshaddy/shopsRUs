package com.shaddytechie.shopsRUs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shaddytechie.shopsRUs.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
Customer findByCustomerId(String customerId);
Customer findByName(String name);
//@Query(
//		  value = "SELECT name FROM customer u WHERE u.name = :name", 
//		  nativeQuery = true)
//Boolean existByName(@Param("name")String name);
//@Query(
//		  value = "SELECT customer_Id FROM customer u WHERE u.customer_Id = :customerId", 
//		  nativeQuery = true)
//Boolean existByCustomerId(String customerId);
boolean existsByName(@Param("name")String name);
boolean existsByCustomerId(String customerId);
}
