package com.excel.homeas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.homeas.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Optional<Admin> findByEmail(String email);

}
