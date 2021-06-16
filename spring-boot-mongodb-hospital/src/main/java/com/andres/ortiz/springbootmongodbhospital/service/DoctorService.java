package com.andres.ortiz.springbootmongodbhospital.service;

import com.andres.ortiz.springbootmongodbhospital.model.Doctor;
import com.andres.ortiz.springbootmongodbhospital.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor){
        return doctorRepository.insert(doctor);
    }

    public Doctor updateDoctor(Doctor doctor) {
        Doctor savedDoctor = doctorRepository.findById(doctor.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Doctor by ID %s", doctor.getId())));

        if(doctor.getFirstName()!=null)
            savedDoctor.setFirstName(doctor.getFirstName());
        if(doctor.getLastName()!=null)
            savedDoctor.setLastName(doctor.getLastName());
        if(doctor.getBirthday()!=null)
            savedDoctor.setBirthday(doctor.getBirthday());
        if(doctor.getAddress()!=null)
            savedDoctor.setAddress(doctor.getAddress());
        if(doctor.getPictureUrl()!=null)
            savedDoctor.setPictureUrl(doctor.getPictureUrl());
        if(doctor.getCreationDate()!=null)
            savedDoctor.setCreationDate(doctor.getCreationDate());
        if(doctor.getLastUpdate()!=null)
            savedDoctor.setLastUpdate(doctor.getLastUpdate());
        if(doctor.getCreatedbyId()!=null)
            savedDoctor.setCreatedbyId(doctor.getCreatedbyId());
        if(doctor.getUpdatedbyId()!=null)
            savedDoctor.setUpdatedbyId(doctor.getUpdatedbyId());
        if(doctor.getSpecialityId()!=null && doctor.getSpecialityId().length!=0)
            savedDoctor.setSpecialityId(doctor.getSpecialityId());
        if(doctor.getHospitalId()!=null && doctor.getHospitalId().length!=0)
            savedDoctor.setHospitalId(doctor.getHospitalId());
        if(doctor.getPatientId()!=null && doctor.getPatientId().length!=0)
            savedDoctor.setPatientId(doctor.getPatientId());

        return doctorRepository.save(savedDoctor);
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
    public Doctor getById(String id){
        return doctorRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("Cannot Find Doctor by id %s", id)));
    }

    public List<Doctor> getByFirstName(String firstName){
        return doctorRepository.findByFirstNameStartsWith(firstName);
    }

    public List<Doctor> getByLastName(String lastName){
        return doctorRepository.findByLastNameStartsWith(lastName);
    }
    public void deleteDoctor(String id){
        doctorRepository.deleteById(id);
    }
}
