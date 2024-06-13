package com.excel.homeas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.homeas.entity.Technician;

public interface TechnicianRepository extends JpaRepository<Technician, Integer> {

    Optional<Technician> findByEmail(String email);

}
