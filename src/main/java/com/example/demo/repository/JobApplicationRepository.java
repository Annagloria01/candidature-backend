package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer>{

}
