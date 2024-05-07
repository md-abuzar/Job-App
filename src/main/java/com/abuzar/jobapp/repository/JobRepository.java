package com.abuzar.jobapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abuzar.jobapp.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}
