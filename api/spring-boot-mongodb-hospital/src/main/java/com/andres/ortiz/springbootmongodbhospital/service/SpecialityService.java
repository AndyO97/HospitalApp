package com.andres.ortiz.springbootmongodbhospital.service;

import com.andres.ortiz.springbootmongodbhospital.model.Speciality;
import com.andres.ortiz.springbootmongodbhospital.repository.SpecialityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SpecialityService {
    private final SpecialityRepository specialityRepository;

    public Speciality addSpeciality(Speciality speciality){
        return specialityRepository.insert(speciality);
    }

    public Speciality updateSpeciality(Speciality speciality) {
        Speciality savedSpeciality = specialityRepository.findById(speciality.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Speciality by ID %s", speciality.getId())));

        savedSpeciality.setTitle(speciality.getTitle());
        savedSpeciality.setDescription(speciality.getDescription());
        savedSpeciality.setIconUrl(speciality.getIconUrl());
        savedSpeciality.setCreationDate(speciality.getCreationDate());
        savedSpeciality.setLastUpdate(speciality.getLastUpdate());
        savedSpeciality.setCreatedbyId(speciality.getCreatedbyId());
        savedSpeciality.setUpdatedbyId(speciality.getUpdatedbyId());
        savedSpeciality.setDoctorId(speciality.getDoctorId());


        return specialityRepository.save(speciality);
    }

    public List<Speciality> getAllSpecialitys(){
        return specialityRepository.findAll();
    }
    public Speciality getById(String id){
        return specialityRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("Cannot Find Speciality by id %s", id)));
    }
    public void deleteSpeciality(String id){
        specialityRepository.deleteById(id);
    }
}
