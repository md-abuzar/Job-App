package com.abuzar.jobapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abuzar.jobapp.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
}
