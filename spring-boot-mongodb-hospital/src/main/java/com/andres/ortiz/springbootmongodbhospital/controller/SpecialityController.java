package com.andres.ortiz.springbootmongodbhospital.controller;

import com.andres.ortiz.springbootmongodbhospital.model.Speciality;
import com.andres.ortiz.springbootmongodbhospital.service.SpecialityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/speciality")
@RequiredArgsConstructor
public class SpecialityController {

    private final SpecialityService specialityService;

    @PostMapping
    public ResponseEntity<Speciality> addSpeciality(@RequestBody Speciality speciality){
        return ResponseEntity.ok(specialityService.addSpeciality(speciality));
    }

    @PatchMapping
    public ResponseEntity<Speciality> updateSpeciality(@RequestBody Speciality speciality) {
        return ResponseEntity.ok(specialityService.updateSpeciality(speciality));
    }

    @PatchMapping("/updateByTitle")
    public ResponseEntity<Speciality> updateSpecialityByTitle(@RequestBody Speciality speciality) {
        return ResponseEntity.ok(specialityService.updateSpecialityByTitle(speciality));
    }

    @GetMapping
    public ResponseEntity<List<Speciality>> getAllSpecialitys(){
        return ResponseEntity.ok(specialityService.getAllSpecialitys());
    }

    @GetMapping("getById/{id}")
    public ResponseEntity getById(@PathVariable String id){
        return ResponseEntity.ok(specialityService.getById(id));
    }

    @GetMapping("getByDoctorId/{doctorId}")
    public ResponseEntity<List<Speciality>> getByDoctorId(@PathVariable String doctorId){
        return ResponseEntity.ok(specialityService.getByDoctorId(doctorId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSpeciality(@PathVariable String id){
        specialityService.deleteSpeciality(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
