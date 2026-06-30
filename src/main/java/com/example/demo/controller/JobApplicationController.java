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
import com.example.demo.repository.JobApplicationRepository;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationController(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    //GET
    @GetMapping
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    //GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getById(@PathVariable Integer id) {
        // Cerchiamo la candidatura. Se c'è la restituisce, altrimenti lancia un errore controllato
        Optional<JobApplication> jobApplication = jobApplicationRepository.findById(id);
        return jobApplication.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> update(@PathVariable Integer id, @RequestBody JobApplication applicationDetails) {
        Optional<JobApplication> existing = jobApplicationRepository.findById(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Prendiamo la candidatura originale dal database
        JobApplication jobApplication = existing.get();

        // Aggiorniamo i singoli campi uno a uno
        jobApplication.setCompanyName(applicationDetails.getCompanyName());
        jobApplication.setJobTitle(applicationDetails.getJobTitle());
        jobApplication.setJobDescription(applicationDetails.getJobDescription());
        jobApplication.setJobLocation(applicationDetails.getJobLocation());
        jobApplication.setApplicationStatus(applicationDetails.getApplicationStatus());
        jobApplication.setHrContactedName(applicationDetails.getHrContactedName());
        jobApplication.setNotes(applicationDetails.getNotes());
        // Se non vuoi far modificare la data, ti basta non mettere il setter della data qui!

        // Salviamo l'oggetto aggiornato
        JobApplication updated = jobApplicationRepository.save(jobApplication);
        return ResponseEntity.ok(updated);
    }

    //POST
    @PostMapping
    public ResponseEntity<JobApplication> create(@RequestBody JobApplication jobApplication) {
        JobApplication saved = jobApplicationRepository.save(jobApplication);
        return ResponseEntity.status(201).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!jobApplicationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jobApplicationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
