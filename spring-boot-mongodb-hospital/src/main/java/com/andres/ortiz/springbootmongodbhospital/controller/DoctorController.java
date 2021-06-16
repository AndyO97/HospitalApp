package com.andres.ortiz.springbootmongodbhospital.controller;

import com.andres.ortiz.springbootmongodbhospital.model.Doctor;
import com.andres.ortiz.springbootmongodbhospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        return ResponseEntity.ok(doctorService.addDoctor(doctor));
    }

    @PatchMapping
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.updateDoctor(doctor));
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("getById/{id}")
    public ResponseEntity getById(@PathVariable String id){
        return ResponseEntity.ok(doctorService.getById(id));
    }

    @GetMapping("getByFirstName/{firstName}")
    public ResponseEntity<List<Doctor>> getByFirstName(@PathVariable String firstName){
        return ResponseEntity.ok(doctorService.getByFirstName(firstName));
    }

    @GetMapping("getByLastName/{lastName}")
    public ResponseEntity<List<Doctor>> getByLastName(@PathVariable String lastName){
        return ResponseEntity.ok(doctorService.getByLastName(lastName));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDoctor(@PathVariable String id){
        doctorService.deleteDoctor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
