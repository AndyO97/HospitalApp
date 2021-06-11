package com.andres.ortiz.springbootmongodbhospital.controller;

import com.andres.ortiz.springbootmongodbhospital.model.Hospital;
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
    public ResponseEntity addHospital(@RequestBody Hospital hospital){
        hospitalService.addHospital(hospital);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping
    public ResponseEntity updateHospital(@RequestBody Hospital hospital) {
        hospitalService.updateHospital(hospital);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals(){
        return ResponseEntity.ok(hospitalService.getAllHospitals());
    }

    @GetMapping("getById/{id}")
    public ResponseEntity getById(@PathVariable String id){
        return ResponseEntity.ok(hospitalService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHospital(@PathVariable String id){
        hospitalService.deleteHospital(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
