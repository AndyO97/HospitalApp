package com.andres.ortiz.springbootmongodbhospital.service;

import com.andres.ortiz.springbootmongodbhospital.model.History;
import com.andres.ortiz.springbootmongodbhospital.model.Patient;
import com.andres.ortiz.springbootmongodbhospital.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient addPatient(Patient patient){
        return patientRepository.insert(patient);
    }

    public Patient updatePatient(Patient patient) {
        Patient savedPatient = patientRepository.findById(patient.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Patient by ID %s", patient.getId())));

        if(patient.getFirstName()!=null)
        savedPatient.setFirstName(patient.getFirstName());
        if(patient.getLastName()!=null)
        savedPatient.setLastName(patient.getLastName());
        if(patient.getBirthday()!=null)
        savedPatient.setBirthday(patient.getBirthday());
        if(patient.getAddress()!=null)
        savedPatient.setAddress(patient.getAddress());
        if(patient.getPictureUrl()!=null)
        savedPatient.setPictureUrl(patient.getPictureUrl());
        if(patient.getCreationDate()!=null)
        savedPatient.setCreationDate(patient.getCreationDate());
        if(patient.getLastUpdate()!=null)
        savedPatient.setLastUpdate(patient.getLastUpdate());
        if(patient.getCreatedbyId()!=null)
        savedPatient.setCreatedbyId(patient.getCreatedbyId());
        if(patient.getUpdatedbyId()!=null)
        savedPatient.setUpdatedbyId(patient.getUpdatedbyId());
        if(patient.getHospitalId()!=null)
        savedPatient.setHospitalId(patient.getHospitalId());
        if(patient.getDoctorId()!=null)
        savedPatient.setDoctorId(patient.getDoctorId());

        return patientRepository.save(savedPatient);
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    public Patient getById(String id){
        return patientRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("Cannot Find Patient by id %s", id)));
    }

    public List<Patient> getByFirstName(String firstName){
        return patientRepository.findByFirstNameStartsWith(firstName);
    }

    public List<Patient> getByLastName(String lastName){
        return patientRepository.findByLastNameStartsWith(lastName);
    }

    public void deletePatient(String id){
        patientRepository.deleteById(id);
    }
}
