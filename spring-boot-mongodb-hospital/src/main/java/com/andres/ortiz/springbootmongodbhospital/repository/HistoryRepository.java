package com.andres.ortiz.springbootmongodbhospital.repository;

import com.andres.ortiz.springbootmongodbhospital.model.History;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends MongoRepository<History, String> {
    @Query("{id: ?0}")
    Optional<History> findById(String id);

    List<History> findByPatientId(String patientId);
}
