package com.excel.homeas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.homeas.entity.ServiceRequests;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequests, Integer> {

	Optional<ServiceRequests> findByCustomerEmail(String email);

}
