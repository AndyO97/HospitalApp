package com.andres.ortiz.springbootmongodbhospital.repository;

import com.andres.ortiz.springbootmongodbhospital.model.Speciality;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface SpecialityRepository extends MongoRepository<Speciality, String> {
    @Query("{id: ?0}")
    Optional<Speciality> findById(String id);
}
