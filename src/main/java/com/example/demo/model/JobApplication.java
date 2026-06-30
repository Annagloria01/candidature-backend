package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class JobApplication { //tabella database

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @NotNull
    @Column(name = "company_name", nullable = false, length = 100)
    @Size(min = 3, max = 100, message = "il titolo deve avere tra i 3 e i 100 caratteri")
    private String companyName;

    @NotNull
    @NotBlank
    @Column(name = "job_title", nullable = false, length = 100)
    @Size(min = 3, max = 100, message = "il titolo deve avere tra i 3 e i 100 caratteri")
    private String jobTitle;

    @Column(name = "job_description", length = 255)
    private String jobDescription;

    @Column(name = "job_location")
    private String jobLocation;

    @Column(name = "application_date")
    private LocalDate applicationDate = LocalDate.now();

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "application_status")
    private ApplicationStatus applicationStatus = ApplicationStatus.NOT_CONTACTED;

    @Column(name = "hr_contacted_name")
    private String hrContactedName;

    @Column(name = "notes")
    private String notes;

    protected  JobApplication() {
    }

    public JobApplication(String companyName, String hrContactedName, String jobDescription, String jobLocation, String jobTitle, String notes) {
        this.companyName = companyName;
        this.hrContactedName = hrContactedName;
        this.jobDescription = jobDescription;
        this.jobLocation = jobLocation;
        this.jobTitle = jobTitle;
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getHrContactedName() {
        return hrContactedName;
    }

    public void setHrContactedName(String hrContactedName) {
        this.hrContactedName = hrContactedName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JobApplication{");
        sb.append("companyName=").append(companyName);
        sb.append(", jobTitle=").append(jobTitle);
        sb.append(", jobDescription=").append(jobDescription);
        sb.append(", jobLocation=").append(jobLocation);
        sb.append(", applicationDate=").append(applicationDate);
        sb.append(", applicationStatus=").append(applicationStatus);
        sb.append(", hrContactedName=").append(hrContactedName);
        sb.append(", notes=").append(notes);
        sb.append('}');
        return sb.toString();
    }

}
