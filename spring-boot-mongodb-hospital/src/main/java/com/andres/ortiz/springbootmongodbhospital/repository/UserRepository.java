package com.andres.ortiz.springbootmongodbhospital.repository;

import com.andres.ortiz.springbootmongodbhospital.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{id: ?0}")
    Optional<User> findById(String id);

    Optional<User> findByUsername(String username);

    @Query("{username: ?0, password: ?1}")
    Optional<User> findByCredentials(String username, String password);
}
