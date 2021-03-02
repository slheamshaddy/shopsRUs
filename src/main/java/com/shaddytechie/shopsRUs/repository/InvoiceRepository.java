package com.shaddytechie.shopsRUs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaddytechie.shopsRUs.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer>{

}
