package com.abuzar.jobapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="job")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="min_salary")
	private long minSalary;
	@Column(name="max_salary")
	private long maxSalary;
	@Column(name="location")
	private String location;
	
	@JsonBackReference
	@ManyToOne
	private Company company;

	public Job() {
		
	}
	
	
	public Job(long id, String title, String description, long minSalary, long maxSalary, String location, Company company) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.location = location;
		this.company = company;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(long minSalary) {
		this.minSalary = minSalary;
	}

	public long getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(long maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}
	
}
