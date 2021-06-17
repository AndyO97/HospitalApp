package com.andres.ortiz.springbootmongodbhospital.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("speciality")
public class Speciality {

    @Id
    private String id;
    private String title;
    private String description;
    private String iconUrl;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private String createdbyId;
    private String updatedbyId;

    private String[] doctorId;

    public Speciality() {
        super();
    }

    public Speciality(String title, String description, String iconUrl, LocalDateTime creationDate,
                      LocalDateTime lastUpdate, String createdbyId, String updatedbyId, String[] doctorId) {
        this.title = title;
        this.description = description;
        this.iconUrl = iconUrl;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
        this.createdbyId = createdbyId;
        this.updatedbyId = updatedbyId;
        this.doctorId = doctorId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
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

    public void addDoctorId(String doctorId) {
        String[] array = this.getDoctorId();
        int i=0;
        int n = array.length;
        String newarr[] = new String[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = array[i];

        newarr[n] = doctorId;
        this.doctorId=newarr;
    }

    public void removeDoctorId(String doctorId) {
        String[] array = this.getDoctorId();
        int i=0;
        int n = array.length;
        boolean found = false;
        String newarr[] = new String[n - 1];
        while (i < n){
            if(array[i].equals(doctorId)){
                found = true;
            }
            if(found && i!=n-1){
                newarr[i]=array[i+1];
            }
            else if (!found){
                newarr[i]=array[i];
            }
           i++;
        }
        if(found)
            this.doctorId=newarr;
    }

}
