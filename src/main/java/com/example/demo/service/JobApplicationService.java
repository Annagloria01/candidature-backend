package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.JobApplicationNotFoundException;
import com.example.demo.model.JobApplication;
import com.example.demo.repository.JobApplicationRepository;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    // Injection tramite costruttore, proprio come piace al tuo insegnante
    public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public List<JobApplication> findAll() {
        return jobApplicationRepository.findAll();
    }

    public Optional<JobApplication> findById(Integer id) {
        return jobApplicationRepository.findById(id);
    }

    public JobApplication save(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    public boolean existsById(Integer id) {
        return jobApplicationRepository.existsById(id);
    }

    public void deleteById(Integer id) {
        jobApplicationRepository.deleteById(id);
    }

    // Logica di business centrale per l'aggiornamento controllato
    public JobApplication update(Integer id, JobApplication applicationDetails) {
        // 1. Cerchiamo la candidatura sul database. Se non esiste, lanciamo la nostra eccezione custom
        JobApplication jobApplication = jobApplicationRepository.findById(id)
                .orElseThrow(() -> new JobApplicationNotFoundException(id));

        // 2. Aggiorniamo manualmente ogni singolo campo con i dati nuovi
        jobApplication.setCompanyName(applicationDetails.getCompanyName());
        jobApplication.setJobTitle(applicationDetails.getJobTitle());
        jobApplication.setJobDescription(applicationDetails.getJobDescription());
        jobApplication.setJobLocation(applicationDetails.getJobLocation());
        jobApplication.setApplicationStatus(applicationDetails.getApplicationStatus());
        jobApplication.setHrContactedName(applicationDetails.getHrContactedName());
        jobApplication.setNotes(applicationDetails.getNotes());

        // 3. Salviamo l'oggetto modificato e lo restituiamo
        return jobApplicationRepository.save(jobApplication);

    }
}