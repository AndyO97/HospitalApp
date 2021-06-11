package com.andres.ortiz.springbootmongodbhospital.repository;

import com.andres.ortiz.springbootmongodbhospital.model.Hospital;
import com.andres.ortiz.springbootmongodbhospital.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository extends MongoRepository<Hospital, String> {
    @Query("{id: ?0}")
    Optional<Hospital> findById(String id);

    //@Query("{'title' : ?0}")
    List<Hospital> findByTitleStartsWith(String title);
}
