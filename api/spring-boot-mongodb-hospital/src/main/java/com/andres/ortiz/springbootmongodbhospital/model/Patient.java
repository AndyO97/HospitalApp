package com.andres.ortiz.springbootmongodbhospital.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("patient")
public class Patient {
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

    private String[] hospitalId;
    private String[] doctorId;

    public Patient() {
        super();
    }

    public Patient(String firstName, String lastName, LocalDateTime birthday, String address, String pictureUrl, LocalDateTime creationDate,
                   LocalDateTime lastUpdate, String createdbyId, String updatedbyId, String[] hospitalId, String[] doctorId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.pictureUrl = pictureUrl;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
        this.createdbyId = createdbyId;
        this.updatedbyId = updatedbyId;
        this.hospitalId = hospitalId;
        this.doctorId = doctorId;
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

    public String[] getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String[] hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String[] getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String[] doctorId) {
        this.doctorId = doctorId;
    }
}
