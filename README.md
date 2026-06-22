# 📋 Tracker Candidature Lavoro (Job Application Tracker)

Un'applicazione backend realizzata in **Java** con **Spring Boot** e **Spring Data JPA** progettata per aiutare i programmatori (specialmente junior!) a tracciare e gestire lo stato delle proprie candidature di lavoro in modo semplice ed efficiente.

---

## 🛠️ Tecnologie Utilizzate

* **Java 25**
* **Spring Boot** (Web, Data JPA, Validation)
* **Hibernate** (ORM per la mappatura dei dati)
* **Maven** (Gestione delle dipendenze)

---

## 📊 Struttura dei Dati (Modello)

Ogni candidatura (`JobApplication`) contiene le seguenti informazioni salvate nel database:

| Campo nel DB (Snake Case) | Campo in Java (Camel Case) | Descrizione / Validazione |
| :--- | :--- | :--- |
| `id` | `id` | Chiave primaria autoincrementale (`IDENTITY`) |
| `company_name` | `companyName` | Nome dell'azienda (Obbligatorio, tra 3 e 100 caratteri) |
| `job_title` | `jobTitle` | Titolo della posizione (Obbligatorio, tra 3 e 100 caratteri) |
| `job_description` | `jobDescription` | Descrizione o requisiti del ruolo (Max 255 caratteri) |
| `job_location` | `jobLocation` | Località del lavoro (es. Bologna, Milano) |
| `application_date` | `applicationDate` | Data di invio (Impostata automaticamente al giorno corrente) |
| `application_status` | `applicationStatus` | Stato attuale (Enum memorizzato come stringa nel DB) |
| `hr_contacted_name` | `hrContactedName` | Nome del referente HR o recruiter |
| `notes` | `notes` | Note personali o dettagli aggiuntivi |

---

## 🔄 Stati della Candidatura (Enum)

Il ciclo di vita di una candidatura è gestito tramite l'enum `ApplicationStatus`:
1. `NOT_CONTACTED`: Candidatura inviata, in attesa di risposta.
2. `HR_CONTACTED`: Contattato da un recruiter per un primo screening telefonico.
3. `INTERVIEW_SCHEDULED`: Colloquio conoscitivo o tecnico fissato.
4. `OFFER_RECEIVED`: Proposta di assunzione ricevuta 🎉.
5. `REJECTED`: Esito negativo.

---

## 🚀 Endpoint API (Controller)

L'applicazione espone le seguenti API REST sotto l'indirizzo base `/api/applications`:

* **`GET /api/applications`**
  * **Descrizione:** Recupera la lista completa di tutte le candidature salvate.
  * **Risposta:** JSON con l'elenco delle righe.
* **`POST /api/applications`**
  * **Descrizione:** Crea e convalida una nuova candidatura.
  * **Validazione:** Attiva i controlli `@Valid` (es. impedisce il salvataggio se i caratteri del titolo sono insufficienti).

---

## ⚙️ Come Avviare il Progetto

1. Clona la repository sul tuo computer:
   ```bash
   git clone [https://github.com/tuo-username/nome-repo.git](https://github.com/tuo-username/nome-repo.git)
