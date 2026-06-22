-- File data.sql definitivo e pulito in snake_case

INSERT INTO job_application (
    company_name, 
    job_title, 
    job_description, 
    job_location, 
    application_date, 
    application_status, 
    hr_contacted_name, 
    notes
) VALUES (
    'Google', 
    'Junior Java Developer', 
    'Sviluppo di microservizi con Spring Boot', 
    'Bologna', 
    CURRENT_DATE, 
    'NOT_CONTACTED', 
    'Maria Rossi', 
    'Inviato CV tramite LinkedIn'
);

INSERT INTO job_application (
    company_name, 
    job_title, 
    job_description, 
    job_location, 
    application_date, 
    application_status, 
    hr_contacted_name, 
    notes
) VALUES (
    'Ferrari', 
    'Backend Engineer Intern', 
    'Ottimizzazione query e gestione flussi dati', 
    'Maranello', 
    CURRENT_DATE, 
    'HR_CONTACTED', 
    'Luigi Bianchi', 
    'Primo colloquio conoscitivo fissato per settimana prossima'
);