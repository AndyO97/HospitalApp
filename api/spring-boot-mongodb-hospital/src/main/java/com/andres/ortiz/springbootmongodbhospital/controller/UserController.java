package com.andres.ortiz.springbootmongodbhospital.controller;

import com.andres.ortiz.springbootmongodbhospital.model.User;
import com.andres.ortiz.springbootmongodbhospital.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //For signing up:
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    //For login:
    @PostMapping("login")
    public ResponseEntity<User> getByCredentials(@RequestBody User user){
        return ResponseEntity.ok(userService.getByCredentials(user));
    }

    @GetMapping("getByUsername/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable String username){
        return ResponseEntity.ok(userService.getByUsername(username));
    }

    @PatchMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("getById/{id}")
    public ResponseEntity getById(@PathVariable String id){
        return ResponseEntity.ok(userService.getById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
