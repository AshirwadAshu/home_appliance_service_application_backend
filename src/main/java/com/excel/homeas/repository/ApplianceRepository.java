package com.excel.homeas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.homeas.entity.Appliance;

public interface ApplianceRepository extends JpaRepository<Appliance, Integer> {

    Optional<Appliance> findByCustomerEmail(String email);

}
