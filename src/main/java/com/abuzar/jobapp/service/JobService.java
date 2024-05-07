package com.abuzar.jobapp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abuzar.jobapp.model.Job;
import com.abuzar.jobapp.repository.JobRepository;


@Service
public class JobService {

	//private List<Job> jobs = new ArrayList<>();
	//private long nextId = 1; 
	
	JobRepository jobRepository;
	
	public JobService(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}
	
	
	public List<Job> findAll()
	{
		return jobRepository.findAll();
	}
	
	public void addJobs(Job job)
	{
		jobRepository.save(job);
		
	}
	
	public Job findById(Long id)
	{
		return jobRepository.findById(id).orElse(null);
			
	}
	
	public Boolean deleteById(Long id)
	{
		try {
		jobRepository.deleteById(id);
		return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean updateJob(Long id , Job updateJob)
	{
		Optional<Job> optionalJob = jobRepository.findById(id);
		
		if(optionalJob.isPresent())
		{
			Job job = optionalJob.get();
			job.setId(updateJob.getId());
			job.setTitle(updateJob.getTitle());
			job.setDescription(updateJob.getDescription());
			job.setMinSalary(updateJob.getMinSalary());
			job.setMaxSalary(updateJob.getMaxSalary());
			job.setLocation(updateJob.getLocation());
			job.setCompany(updateJob.getCompany());
			jobRepository.save(job);
			return true;
		}
		return false;
	}

}
