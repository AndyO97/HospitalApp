package com.andres.ortiz.springbootmongodbhospital.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("doctor")
public class Doctor {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private String address;
    private String pictureUrl;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private String createdbyId;
    private String updatedbyId;

    private String[] specialityId;
    private String[] hospitalId;
    private String[] patientId;

    public Doctor() {
        super();
    }

    public Doctor(String firstName, String lastName, LocalDateTime birthday, String address, String pictureUrl, LocalDateTime creationDate, LocalDateTime lastUpdate,
                  String createdbyId, String updatedbyId, String[] specialityId, String[] hospitalId, String[] patientId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.pictureUrl = pictureUrl;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
        this.createdbyId = createdbyId;
        this.updatedbyId = updatedbyId;
        this.specialityId = specialityId;
        this.hospitalId = hospitalId;
        this.patientId = patientId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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

    public String[] getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(String[] specialityId) {
        this.specialityId = specialityId;
    }

    public String[] getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String[] hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String[] getPatientId() {
        return patientId;
    }

    public void setPatientId(String[] patientId) {
        this.patientId = patientId;
    }
}
