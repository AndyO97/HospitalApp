package com.andres.ortiz.springbootmongodbhospital.service;

import com.andres.ortiz.springbootmongodbhospital.model.User;
import com.andres.ortiz.springbootmongodbhospital.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public User addUser(User user){
        return userRepository.insert(user);
    }

    public User updateUser(User user) {
        User savedUser = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find User by ID %s", user.getId())));

        savedUser.setUsername(user.getUsername());
        savedUser.setPassword(user.getPassword());


        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getById(String id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException(
                String.format("Cannot Find User by id %s", id)));
    }

    public User getByUsername(String username){
        //return userRepository.findByUsername(username);
        return userRepository.findByUsername(username).orElseThrow(()->new RuntimeException(
                String.format("Cannot Find User by username %s", username)));
    }

    public User getByCredentials(User user){

        return userRepository.findByCredentials(user.getUsername(), user.getPassword()).orElseThrow(()->new RuntimeException(
                String.format("Wrong combination of username and password")));
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
