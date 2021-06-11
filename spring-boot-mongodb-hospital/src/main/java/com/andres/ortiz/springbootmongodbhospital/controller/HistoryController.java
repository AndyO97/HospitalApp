package com.andres.ortiz.springbootmongodbhospital.controller;

import com.andres.ortiz.springbootmongodbhospital.model.History;
import com.andres.ortiz.springbootmongodbhospital.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;

    @PostMapping
    public ResponseEntity<History> addHistory(@RequestBody History history){
        return ResponseEntity.ok(historyService.addHistory(history));
    }

    @PatchMapping
    public ResponseEntity<History> updateHistory(@RequestBody History history) {
        return ResponseEntity.ok(historyService.updateHistory(history));
    }

    @GetMapping
    public ResponseEntity<List<History>> getAllHistory(){
        return ResponseEntity.ok(historyService.getAllHistory());
    }

    @GetMapping("getById/{id}")
    public ResponseEntity getById(@PathVariable String id){
        return ResponseEntity.ok(historyService.getById(id));
    }

    /*
    @GetMapping("getByPatientId/{id}")
    public ResponseEntity getByPatientId(@PathVariable String id){
        return ResponseEntity.ok(historyService.getByPatientId(id));
    }
    */

    @GetMapping("getByPatientId/{patientId}")
    public ResponseEntity<List<History>> getByPatientId(@PathVariable String patientId){
        return ResponseEntity.ok(historyService.getByPatientId(patientId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHistory(@PathVariable String id){
        historyService.deleteHistory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
