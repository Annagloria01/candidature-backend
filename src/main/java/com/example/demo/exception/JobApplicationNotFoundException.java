package com.example.demo.exception;

public class JobApplicationNotFoundException extends RuntimeException {
    public JobApplicationNotFoundException(Integer id) {
        super("Candidatura con id " + id + " non trovata");
    }
}