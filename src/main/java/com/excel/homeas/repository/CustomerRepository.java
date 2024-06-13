package com.excel.homeas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.homeas.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByEmail(String email);
	
}
