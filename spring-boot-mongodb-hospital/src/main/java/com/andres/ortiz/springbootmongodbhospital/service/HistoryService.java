package com.andres.ortiz.springbootmongodbhospital.service;

import com.andres.ortiz.springbootmongodbhospital.model.History;
import com.andres.ortiz.springbootmongodbhospital.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HistoryService {
    private final HistoryRepository historyRepository;

    public History addHistory(History history){
        return historyRepository.insert(history);
    }

    public History updateHistory(History history) {
        History savedHistory = historyRepository.findById(history.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find History by ID %s", history.getId())));
        if(history.getDescription()!=null)
            savedHistory.setDescription(history.getDescription());
        if (history.getUserDate()!=null)
            savedHistory.setUserDate(history.getUserDate());
        //if (history.getPatientId()!=null)
        //savedHistory.setPatientId(history.getPatientId());
        if(history.getLastUpdate()!=null)
            savedHistory.setLastUpdate(history.getLastUpdate());
        if(history.getUpdatedbyId()!=null)
            savedHistory.setUpdatedbyId(history.getUpdatedbyId());



        return historyRepository.save(savedHistory);
    }

    public List<History> getAllHistory(){
        return historyRepository.findAll();
    }
    public History getById(String id){
        return historyRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("Cannot Find History by id %s", id)));
    }

    public List<History> getByPatientId(String patientId){
        return historyRepository.findByPatientId(patientId);
    }
    public void deleteHistory(String id){
        historyRepository.deleteById(id);
    }
}
