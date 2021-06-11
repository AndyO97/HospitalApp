package com.andres.ortiz.springbootmongodbhospital.service;

import com.andres.ortiz.springbootmongodbhospital.model.Hospital;
import com.andres.ortiz.springbootmongodbhospital.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public void addHospital(Hospital hospital){
        hospitalRepository.insert(hospital);
    }

    public void updateHospital(Hospital hospital) {
        Hospital savedHospital = hospitalRepository.findById(hospital.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Hospital by ID %s", hospital.getId())));

        savedHospital.setTitle(hospital.getTitle());
        savedHospital.setCreationDate(hospital.getCreationDate());
        savedHospital.setLastUpdate(hospital.getLastUpdate());
        savedHospital.setCreatedbyId(hospital.getCreatedbyId());
        savedHospital.setUpdatedbyId(hospital.getUpdatedbyId());
        savedHospital.setDoctorId(hospital.getDoctorId());
        savedHospital.setPatientId(hospital.getPatientId());

        hospitalRepository.save(hospital);
    }

    public List<Hospital> getAllHospitals(){
        return hospitalRepository.findAll();
    }
    public Hospital getById(String id){
        return hospitalRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("Cannot Find Hospital by id %s", id)));
    }
    public void deleteHospital(String id){
        hospitalRepository.deleteById(id);
    }
}
