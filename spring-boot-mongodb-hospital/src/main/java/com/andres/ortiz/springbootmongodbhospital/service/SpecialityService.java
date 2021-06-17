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

        if(speciality.getTitle()!=null && !(speciality.getTitle().equals("")))
            savedSpeciality.setTitle(speciality.getTitle());
        if(speciality.getDescription()!=null && !(speciality.getDescription().equals("")))
            savedSpeciality.setDescription(speciality.getDescription());
        if(speciality.getIconUrl()!=null && !(speciality.getIconUrl().equals("")))
            savedSpeciality.setIconUrl(speciality.getIconUrl());
        if(speciality.getLastUpdate()!=null && !(speciality.getLastUpdate().equals("")))
            savedSpeciality.setLastUpdate(speciality.getLastUpdate());
        if(speciality.getUpdatedbyId()!=null && !(speciality.getUpdatedbyId().equals("")))
            savedSpeciality.setUpdatedbyId(speciality.getUpdatedbyId());
        if(speciality.getDoctorId()!=null && speciality.getDoctorId().length!=0)
        savedSpeciality.setDoctorId(speciality.getDoctorId());

        return specialityRepository.save(savedSpeciality);
    }

    public Speciality updateSpecialityByTitle(Speciality speciality) {
        Speciality savedSpeciality = specialityRepository.findByTitle(speciality.getTitle()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Speciality by title %s", speciality.getTitle())));

        if(speciality.getLastUpdate()!=null && !(speciality.getLastUpdate().equals("")))
            savedSpeciality.setLastUpdate(speciality.getLastUpdate());
        if(speciality.getUpdatedbyId()!=null && !(speciality.getUpdatedbyId().equals("")))
            savedSpeciality.setUpdatedbyId(speciality.getUpdatedbyId());
        if(speciality.getDoctorId()!=null && speciality.getDoctorId().length!=0)
            savedSpeciality.addDoctorId(speciality.getDoctorId()[0]);

        return specialityRepository.save(savedSpeciality);
    }

    public Speciality removeDoctorId(String specialityId, String doctorId) {
        Speciality savedSpeciality = specialityRepository.findById(specialityId).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Speciality by id %s", specialityId)));

        savedSpeciality.removeDoctorId(doctorId);

        return specialityRepository.save(savedSpeciality);
    }

    public List<Speciality> getAllSpecialitys(){
        return specialityRepository.findAll();
    }
    public Speciality getById(String id){
        return specialityRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("Cannot Find Speciality by id %s", id)));
    }

    public Speciality getByTitle(String title){
        return specialityRepository.findByTitle(title).orElseThrow(()->new RuntimeException(
                String.format("Cannot Find Speciality by title %s", title)));
    }

    public List<Speciality> getByDoctorId(String doctorId){
        return specialityRepository.findByDoctorId(doctorId);
    }
    public void deleteSpeciality(String id){
        specialityRepository.deleteById(id);
    }
}
