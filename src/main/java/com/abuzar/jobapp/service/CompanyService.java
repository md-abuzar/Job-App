package com.abuzar.jobapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abuzar.jobapp.model.Company;
import com.abuzar.jobapp.repository.CompanyRepository;
import com.abuzar.jobapp.repository.JobRepository;

@Service
public class CompanyService {
	
	CompanyRepository companyRepository;
	
	JobRepository jobRepository;
	
	
	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	public  List<Company> getAllCompanies(){
		return companyRepository.findAll();
	}
	
	public Company findCompanyById(Long id) {
		return companyRepository.findById(id).orElse(null);
	}

	public void createCompany(Company company) {
		companyRepository.save(company);
		
	}

	public Boolean deleteCompany(Long id) {
		if(companyRepository.existsById(id))
		{
			companyRepository.deleteById(id);
			return true;
		} else {
		return false;
		}
	}
		
	public Boolean updateCompany(Long id, Company updatedCompany) {
		Optional<Company> optionalCompany = companyRepository.findById(id);
		if (optionalCompany.isPresent())
		{
			Company company = optionalCompany.get();
			company.setName(updatedCompany.getName());
			company.setDescription(updatedCompany.getDescription());
			company.setJobs(updatedCompany.getJobs());
			companyRepository.save(company);
			return true;
		} else {
			return false;
		}
		
	}
		
}
