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

        savedDoctor.setFirstName(doctor.getFirstName());
        savedDoctor.setLastName(doctor.getLastName());
        savedDoctor.setBirthday(doctor.getBirthday());
        savedDoctor.setAddress(doctor.getAddress());
        savedDoctor.setPictureUrl(doctor.getPictureUrl());
        savedDoctor.setCreationDate(doctor.getCreationDate());
        savedDoctor.setLastUpdate(doctor.getLastUpdate());
        savedDoctor.setCreatedbyId(doctor.getCreatedbyId());
        savedDoctor.setUpdatedbyId(doctor.getUpdatedbyId());
        savedDoctor.setSpecialityId(doctor.getSpecialityId());
        savedDoctor.setHospitalId(doctor.getHospitalId());
        savedDoctor.setPatientId(doctor.getPatientId());

        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
    public Doctor getById(String id){
        return doctorRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("Cannot Find Doctor by id %s", id)));
    }
    public void deleteDoctor(String id){
        doctorRepository.deleteById(id);
    }
}
