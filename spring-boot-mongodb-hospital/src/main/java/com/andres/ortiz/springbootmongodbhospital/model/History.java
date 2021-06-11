package com.andres.ortiz.springbootmongodbhospital.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("history")
public class History {
    @Id
    private String id;
    private String description;
    private LocalDateTime userDate;
    private String patientId;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private String createdbyId;
    private String updatedbyId;

    public History() {
        super();
    }

    public History(String description, LocalDateTime userDate, String patientId,
                   LocalDateTime creationDate, LocalDateTime lastUpdate, String createdbyId, String updatedbyId) {
        this.description = description;
        this.userDate = userDate;
        this.patientId = patientId;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
        this.createdbyId = createdbyId;
        this.updatedbyId = updatedbyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getUserDate() {
        return userDate;
    }

    public void setUserDate(LocalDateTime userDate) {
        this.userDate = userDate;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
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
}
