package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.JobApplication;
import com.example.demo.service.JobApplicationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    // Constructor Injection sul Service
    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    // GET
    @GetMapping
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationService.findAll();
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getById(@PathVariable Integer id) {
        Optional<JobApplication> jobApplication = jobApplicationService.findById(id);
        return jobApplication.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> update(@PathVariable Integer id, @Valid @RequestBody JobApplication applicationDetails) {
        JobApplication updated = jobApplicationService.update(id, applicationDetails);
        return ResponseEntity.ok(updated);
    }

    // POST
    @PostMapping
    public ResponseEntity<JobApplication> create(@Valid @RequestBody JobApplication jobApplication) {
        JobApplication saved = jobApplicationService.save(jobApplication);
        return ResponseEntity.status(201).body(saved);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!jobApplicationService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jobApplicationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
