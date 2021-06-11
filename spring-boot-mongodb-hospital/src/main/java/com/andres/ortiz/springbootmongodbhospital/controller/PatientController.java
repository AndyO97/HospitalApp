package com.andres.ortiz.springbootmongodbhospital.controller;

import com.andres.ortiz.springbootmongodbhospital.model.History;
import com.andres.ortiz.springbootmongodbhospital.model.Patient;
import com.andres.ortiz.springbootmongodbhospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        return ResponseEntity.ok(patientService.addPatient(patient));
    }

    @PatchMapping
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(patient));
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("getById/{id}")
    public ResponseEntity getById(@PathVariable String id){
        return ResponseEntity.ok(patientService.getById(id));
    }

    @GetMapping("getByFirstName/{firstName}")
    public ResponseEntity<List<Patient>> getByFirstName(@PathVariable String firstName){
        return ResponseEntity.ok(patientService.getByFirstName(firstName));
    }

    @GetMapping("getByLastName/{lastName}")
    public ResponseEntity<List<Patient>> getByLastName(@PathVariable String lastName){
        return ResponseEntity.ok(patientService.getByLastName(lastName));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable String id){
        patientService.deletePatient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
