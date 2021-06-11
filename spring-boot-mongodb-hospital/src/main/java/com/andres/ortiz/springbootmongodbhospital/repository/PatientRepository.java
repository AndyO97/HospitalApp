package com.andres.ortiz.springbootmongodbhospital.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.andres.ortiz.springbootmongodbhospital.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends MongoRepository<Patient, String>{
    @Query("{id: ?0}")
    Optional<Patient> findById(String id);

    List<Patient> findByFirstNameStartsWith(String firstName);

    List<Patient> findByLastNameStartsWith(String lastName);

}
