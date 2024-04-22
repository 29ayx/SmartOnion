package com.smartonion.salt.controller;

import org.springframework.web.bind.annotation.RestController;

import com.smartonion.salt.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return service.addUser(user);
    }

    @GetMapping
    public List<User> getUser(){
        return service.findAllUsers();
    }
    
    
}
