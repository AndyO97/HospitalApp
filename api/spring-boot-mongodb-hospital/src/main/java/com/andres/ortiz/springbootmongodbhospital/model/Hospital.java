package com.andres.ortiz.springbootmongodbhospital.model;

import java.time.LocalDateTime;

public class Hospital {
    private String id;
    private String title;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private String createdbyId;
    private String updatedbyId;

    private String[] doctorId;
    private String[] patientId;

    public Hospital() {
        super();
    }

    public Hospital(String title, LocalDateTime creationDate,
                    LocalDateTime lastUpdate, String createdbyId, String updatedbyId, String[] doctorId, String[] patientId) {
        this.title = title;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
        this.createdbyId = createdbyId;
        this.updatedbyId = updatedbyId;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getCreatedbyId() {
        return createdbyId;
    }

    public void setCreatedbyId(String createdbyId) {
        this.createdbyId = createdbyId;
    }

    public String getUpdatedbyId() {
        return updatedbyId;
    }

    public void setUpdatedbyId(String updatedbyId) {
        this.updatedbyId = updatedbyId;
    }

    public String[] getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String[] doctorId) {
        this.doctorId = doctorId;
    }

    public String[] getPatientId() {
        return patientId;
    }

    public void setPatientId(String[] patientId) {
        this.patientId = patientId;
    }
}
