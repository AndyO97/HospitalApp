package com.andres.ortiz.springbootmongodbhospital.controller;

import com.andres.ortiz.springbootmongodbhospital.model.Hospital;
import com.andres.ortiz.springbootmongodbhospital.model.Patient;
import com.andres.ortiz.springbootmongodbhospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hospitals")
@RequiredArgsConstructor
public class HospitalController {
    private final HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<Hospital> addHospital(@RequestBody Hospital hospital){
        return ResponseEntity.ok(hospitalService.addHospital(hospital));
    }

    @PatchMapping
    public ResponseEntity updateHospital(@RequestBody Hospital hospital) {
        return ResponseEntity.ok(hospitalService.updateHospital(hospital));
    }

    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals(){
        return ResponseEntity.ok(hospitalService.getAllHospitals());
    }

    @GetMapping("getById/{id}")
    public ResponseEntity getById(@PathVariable String id){
        return ResponseEntity.ok(hospitalService.getById(id));
    }

    @GetMapping("getByTitle/{title}")
    public ResponseEntity<List<Hospital>> findByTitleStartsWith(@PathVariable String title){
        return ResponseEntity.ok(hospitalService.findByTitleStartsWith(title));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHospital(@PathVariable String id){
        hospitalService.deleteHospital(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
