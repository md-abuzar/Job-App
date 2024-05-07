package com.abuzar.jobapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abuzar.jobapp.model.Company;
import com.abuzar.jobapp.model.Job;
import com.abuzar.jobapp.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	CompanyService companyService;
	
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@GetMapping
	public ResponseEntity<List<Company>> getAllCompanies(){
		return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> findById(@PathVariable Long id){
		Company company = companyService.findCompanyById(id);
		if(company != null) {
			return new ResponseEntity<>(company, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<String>createCompany(@RequestBody Company company) {
		companyService.createCompany(company);
		return new ResponseEntity<>("Company Added Successfully", HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
		Boolean isDeleted = companyService.deleteCompany(id);
		if(isDeleted) {
			return new ResponseEntity<>("Company Deleted Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Company Id not Found", HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@RequestBody Company company, @PathVariable Long id) {
		Boolean isUpdated = companyService.updateCompany(id, company);
		if (isUpdated) {
			return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>("Failed to Update", HttpStatus.NOT_FOUND);
		}
	}	

}
