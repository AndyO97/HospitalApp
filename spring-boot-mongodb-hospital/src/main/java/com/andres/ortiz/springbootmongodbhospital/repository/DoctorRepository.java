package com.andres.ortiz.springbootmongodbhospital.repository;
import com.andres.ortiz.springbootmongodbhospital.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends MongoRepository<Doctor, String>{
    @Query("{id: ?0}")
    Optional<Doctor> findById(String id);
}
